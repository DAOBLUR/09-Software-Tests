package pe.com.empresa.gestionIntencion.mapper;


import pe.com.empresa.gestionIntencion.dao.entity.IntencionListEntity;
import pe.com.empresa.gestionIntencion.models.IntencionesHome;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IntencionesMapper {
    IntencionesMapper INSTANCE = Mappers.getMapper(IntencionesMapper.class);

    @Mapping(source = "inteId", target = "intencionId")
    @Mapping(source = "inteCantidad", target = "intencionCantidad")
    @Mapping(source = "inteContraparte", target = "intencionContraparte")
    @Mapping(source = "inteComentario", target = "intencionComentario")
    @Mapping(source = "inteFecRegistro", target = "intencionFecRegistro")
    @Mapping(source = "usuaId", target = "usuarioId")
    @Mapping(source = "instId", target = "intrumentoId")
    @Mapping(source = "tipoOperacion", target = "intencionTipoOperacion")
    @Mapping(source = "persNombres", target = "personaNombres")
    @Mapping(source = "nombreOperacion", target = "nombreOperacion")
    @Mapping(source = "inteInstrumento", target = "intencionInstrumento")
    @Mapping(source = "revisadoInte", target = "intencionRevisado")
    @Mapping(source = "inteRevComentario", target = "intencionRevisadoComentario")
    IntencionesHome toHome(IntencionListEntity entity);

    @Mapping(source = "intencionId", target = "inteId")
    @Mapping(source = "intencionCantidad", target = "inteCantidad")
    @Mapping(source = "intencionContraparte", target = "inteContraparte")
    @Mapping(source = "intencionComentario", target = "inteComentario")
    @Mapping(source = "intencionFecRegistro", target = "inteFecRegistro")
    @Mapping(source = "usuarioId", target = "usuaId")
    @Mapping(source = "intrumentoId", target = "instId")
    @Mapping(source = "intencionTipoOperacion", target = "tipoOperacion")
    @Mapping(source = "personaNombres", target = "persNombres")
    @Mapping(source = "nombreOperacion", target = "nombreOperacion")
    @Mapping(source = "intencionInstrumento", target = "inteInstrumento")
    @Mapping(source = "intencionRevisado", target = "revisadoInte")
    @Mapping(source = "intencionRevisadoComentario", target = "inteRevComentario")
    IntencionListEntity toEntity(IntencionesHome home);

}
