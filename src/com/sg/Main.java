package com.sg;

import static com.sg.Functions.mccormick;
import static com.sg.Functions.michalewicz;
import static com.sg.PSO.*;

public class Main {


    public static void main(String[] args) {
        PSO.State state = psoInit(
                new double[]{-1.5, -3.0},
                new double[]{4.0, 4.0},
                new PSO.Parameters(0.0, 0.6, 0.3),
                100
        );
        state = iterate(Functions::mccormick, 40, state);
        state.report("McCormick");
        System.out.printf("f(-.54719, -1.54719) : %.15f\n", mccormick(new double[]{-.54719, -1.54719}));
        System.out.println();

        state = psoInit(
                new double[]{0.0, 0.0},
                new double[]{Math.PI, Math.PI},
                new PSO.Parameters(0.3, 3.0, 0.3),
                1000
        );
        state = iterate(Functions::michalewicz, 30, state);
        state.report("Michalewicz (2D)");
        System.out.printf("f(2.20, 1.57)        : %.15f\n", michalewicz(new double[]{2.20, 1.57}));
    }
}
