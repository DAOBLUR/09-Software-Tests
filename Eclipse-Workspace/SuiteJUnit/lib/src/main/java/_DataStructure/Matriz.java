package _DataStructure;

//https://www.dit.upm.es/~samuelm/docencia/fprg/ejercicio2/Matriz.java

public class Matriz
{
    public double[][] elementos;
    private int nFilas, nCols;

    public Matriz(double[][] elementos)
    {
        nFilas = elementos.length;
        nCols = elementos[0].length;
        this.elementos = new double[nFilas][nCols];
         for(int i=0; i<nFilas; i++) {
             for(int j=0; j<nCols; j++) {
                 this.elementos[i][j] = elementos[i][j];
             }
         }
    }
    
    public Matriz(int nFilas, int nCols) {
        this.nFilas = nFilas;
        this.nCols = nCols;
        elementos = new double[nFilas][nCols];
    }
    
    public Matriz complementaria(int ni, int nj) {
        if (nFilas > 0 && nCols > 0) {        
            Matriz resultado = new Matriz(nFilas-1, nCols-1);
            for (int i=0, ri=0; ri < nFilas-1; i++, ri++) {
                if (i== ni) {
                    i++;
                }
                for (int j=0, rj=0; rj< nCols-1; j++, rj++) {
                    if (j== nj) {
                        j++;
                    }
                    resultado.elementos[ri][rj] = this.elementos[i][j];
                }
            }
            return resultado;
        } else return null;
    }
    
	public double determinante() {
        if (nFilas == 0 || nCols == 0) {
            return 1;
        } else {
            double resultado = 0;
            for (int i=0; i<nFilas; i++) {
                    int j=0;
                    int signo;
                    if ( (i+j)%2 == 0) {
                        signo = 1;
                    } else  {
                        signo = -1;
                    }
                    resultado += signo * elementos[i][j] * complementaria(i, j).determinante();
                }
            return resultado;
        }
    }

	public Matriz producto(double k) {
        Matriz resultado = new Matriz(this.nFilas, this.nCols);
        for (int i=0; i<nFilas; i++) {
            for (int j=0; j<nCols; j++) {
                resultado.elementos[i][j] = k * this.elementos[i][j];
            }
        }
        return resultado;
    }
	
	private static void imprimeElemento(double d) {
        System.out.print( String.format("%1$+01.4g", d) + " ");
    }
	
	public static void imprime(double[][] relementos) {

        String borde = "|";
        
        System.out.println(); 
        for (int i=0; i<relementos.length; i++) {
            System.out.print(borde);
            double[] filai = relementos[i];
            for (int j=0; j<filai.length; j++) {
                imprimeElemento(relementos[i][j]);
            }            
            System.out.print(borde);
            System.out.println();
        }
        System.out.println();
    }
	
	public Matriz transpuesta() {
        Matriz resultado = new Matriz(this.nCols, this.nFilas);
        for (int i=0; i<nFilas; i++) {
            for (int j=0; j<nCols; j++) {
                resultado.elementos[i][j] = this.elementos[j][i];
            }
        }
        return resultado;
    }
	
	public Matriz opuesta() {
        Matriz resultado = new Matriz(this.nFilas, this.nCols);
        for (int i=0; i<nFilas; i++) {
            for (int j=0; j<nCols; j++) {
                resultado.elementos[i][j] = -this.elementos[i][j];
            }
        }
        return resultado;
    }
}