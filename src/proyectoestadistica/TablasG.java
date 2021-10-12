/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestadistica;

/**
 *
 * @author ADMIN
 */
public class TablasG {
    private double Columna1;
    private double Columna2;
    public TablasG(double Columna1, double Columna2){
        this.Columna1 = Columna1;
        this.Columna2 = Columna2;
    }

    public double getColumna1() {
        return Columna1;
    }

    public double getColumna2() {
        return Columna2;
    }

    public void setColumna1(double Columna1) {
        this.Columna1 = Columna1;
    }

    public void setColumna2(double Columna2) {
        this.Columna2 = Columna2;
    }
    
    
    // si es igual que la otra persona 
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TablasG other = (TablasG) obj;
        if (this.Columna1 != other.Columna1) {
            return false;
        }
        if (this.Columna2 != other.Columna2) {
            return false;
        }
        return true;
    }
       
}
