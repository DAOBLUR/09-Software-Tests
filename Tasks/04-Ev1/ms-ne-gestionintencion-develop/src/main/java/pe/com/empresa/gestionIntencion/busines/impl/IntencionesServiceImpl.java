package pe.com.empresa.gestionIntencion.busines.impl;

import lombok.extern.log4j.Log4j;
import pe.com.empresa.framework.tracing.exception.NotFoundException;

import pe.com.empresa.gestionIntencion.busines.IntencionesService;
import pe.com.empresa.gestionIntencion.dao.entity.InstrumentoEntity;

import pe.com.empresa.gestionIntencion.dao.entity.IntencionEntity;
import pe.com.empresa.gestionIntencion.dao.entity.IntencionListEntity;
import pe.com.empresa.gestionIntencion.dao.repository.IntencionListaRepository;
import pe.com.empresa.gestionIntencion.dao.repository.IntencionRepository;
import pe.com.empresa.gestionIntencion.dao.repository.InstrumentoRepository;
import pe.com.empresa.gestionIntencion.expose.dto.request.IntencionesDto;
import pe.com.empresa.gestionIntencion.expose.dto.request.IntencioneRevDto;
import pe.com.empresa.gestionIntencion.expose.dto.request.IntencionesUpdDto;
import pe.com.empresa.gestionIntencion.expose.dto.request.ListadoIntencionesDto;
import pe.com.empresa.gestionIntencion.mapper.IntencionesMapper;
import pe.com.empresa.gestionIntencion.models.IntencionesHome;
import pe.com.empresa.gestionIntencion.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Log4j
@Service
public class IntencionesServiceImpl implements IntencionesService {

    @Autowired
    private IntencionesMapper intencionesMapper;

    @Autowired
    private IntencionRepository intencionRepository;

    @Autowired
    private InstrumentoRepository instrumentoRepository;

    @Autowired
    private IntencionListaRepository genericRepository;


    @Override
    @Transactional(readOnly = true)
    public List<IntencionesHome> listadoIntenciones(ListadoIntencionesDto request) {
        List<IntencionListEntity> intencionesHomeList = genericRepository
                .executeInteSsAll(request.getInstrumento(), request.getTipoOperacion(), request.getNombreCompleto(), request.getUsuarioId(), request.getTipoUsuario(), request.getIntencionRevisado());
        log.info("listadoIntenciones - ListadoIntencionesDto");

        return intencionesHomeList
                .stream()
                .map(IntencionesMapper.INSTANCE::toHome)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public IntencionesDto registroIntenciones(IntencionesDto request) {

        List<InstrumentoEntity> instrumentos  = instrumentoRepository.findByInstDescripcion(request.getInteInstrumento());
        log.info("registroIntenciones instrumentos: " + instrumentos.size());
        if(!instrumentos.isEmpty()){
            throw new NotFoundException("Ya existe un instrumento registrado con el mismo nombre");
        }
        Integer result = intencionRepository
                .executeInteSave(request.getIntencionCantidad(), request.getIntencionContraparte(), request.getIntencionComentario(), request.getTipoOperacion(), request.getUsuarioId(), request.getInstrumentoId(), request.getInteInstrumento());
        log.info(result);
        return request;
    }

    @Override
    public IntencionesUpdDto actualizarIntenciones(IntencionesUpdDto request) {
        intencionRepository.findById(request.getIntencionId())
                .orElseThrow(() -> new NotFoundException("No existe una intencion registrada"));

        intencionRepository.executeUpdateIntencion(
                request.getIntencionId(),
                request.getIntecionCantidad(),
                request.getIntencionContraparte(),
                request.getIntencionComentario(),
                request.getTipoOperacion(),
                request.getInteInstrumento());
        return request;
    }

    @Override
    public String eliminarIntenciones(Integer id) {
        intencionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe una intencion registrada"));

        intencionRepository.executeDeleteIntencion(id);
        return Constantes.DELETED_MESSAGE;
    }

    @Override
    public IntencioneRevDto actualizarRevisadoIntencion(IntencioneRevDto request) {
        IntencionEntity intencion = intencionRepository.findById(request.getIntencionId())
                .orElseThrow(() -> new NotFoundException("Intencion no encontrada"));

        intencion.setDRevisado(request.getRevisado());
        intencion.setInteRevComentario(request.getComentario());

        intencionRepository.save(intencion);
        return request;
    }
}
