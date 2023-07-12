package com.teclogi.app.Services;

import com.teclogi.app.Models.MoneyStolen;

public class robServices {


    public MoneyStolen rob(int[] nums){

        //Instanciación del objeto resultante
        MoneyStolen resultObject = new MoneyStolen();

        //Inicialización de variable con el tamaño del arreglo.
        int n = nums.length;

        //Si es 0, no es posible robar nada.
        if (n == 0) {
            resultObject.setMoneyStolen(0);
            return resultObject;
        }

        //Si es 1, sólo es posible ese valor.
        if (n == 1) {
            resultObject.setMoneyStolen(nums[0]);
            return resultObject;
        }

        //Instanciación del objeto de posibles valores a robar. 
        int[] dp = new int[n];

        //El primer valor es el caso de un solo número.
        dp[0] = nums[0];

        //El siguiente valor el máximo entre el primero y el segundo.
        dp[1] = Math.max(nums[0], nums[1]);

        //Itera sobre todo el tamaño del arreglo, obteniendo el máximo entre el acumulado anterior o el valor actual más el acumulado de hace dos casillas.
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        //Retorna el penúltimo valor del arreglo, es decir, el mayor acumulado.        
        resultObject.setMoneyStolen(dp[n-1]);
        return resultObject;
    }

    


}
