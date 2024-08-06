package ar.edu.et7;



public class Calculos {

    public double calcularCuotaFrancesa(float monto, float tna, int cuotas) {

        // Convertir tasa de interés anual a mensual

        double tasaMensual = (tna / 100) / 12;



        // Fórmula para calcular la cuota

        double cuota = (monto * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -cuotas));



        return cuota;

    }

    

    // Método de suma (si es necesario)

    public int sumar(int a, int b, int c) {

        return a + b + c;

    }

}

