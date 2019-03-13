package java.recherche_Tests;

import fr.moko.main.java.games_Launchers.Games.Utilities_Games;
import fr.moko.main.java.games_Launchers.recherche_Launcher.recherche.Defense_Recherche;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Test_RecherchePlusMoins {

    @Test
    public void run_int_TO_arrayInt(){

        Utilities_Games utilities_Games = new Utilities_Games();

        int int_Recherche_NumberOfUnities;

        int int_Scanner;

        int_Recherche_NumberOfUnities = 8;

        int_Scanner = 1;

        assertArrayEquals(utilities_Games.run_int_TO_arrayInt(int_Recherche_NumberOfUnities, int_Scanner), new int[]{0, 0, 0, 0, 0, 0, 0, 1});

        int_Recherche_NumberOfUnities = 8;
        int_Scanner = 22;

        assertArrayEquals(utilities_Games.run_int_TO_arrayInt(int_Recherche_NumberOfUnities, int_Scanner), new int[]{0, 0, 0, 0, 0, 0, 2, 2});

        int_Recherche_NumberOfUnities = 8;
        int_Scanner = 333;

        assertArrayEquals(utilities_Games.run_int_TO_arrayInt(int_Recherche_NumberOfUnities, int_Scanner), new int[]{0, 0, 0, 0, 0, 3, 3, 3});

        int_Recherche_NumberOfUnities = 8;
        int_Scanner = 4444;

        assertArrayEquals(utilities_Games.run_int_TO_arrayInt(int_Recherche_NumberOfUnities, int_Scanner), new int[]{0, 0, 0, 0, 4, 4, 4, 4});

        int_Recherche_NumberOfUnities = 8;
        int_Scanner = 55555;

        assertArrayEquals(utilities_Games.run_int_TO_arrayInt(int_Recherche_NumberOfUnities, int_Scanner), new int[]{0, 0, 0, 5, 5, 5, 5, 5});

        int_Recherche_NumberOfUnities = 8;
        int_Scanner = 666666;

        assertArrayEquals(utilities_Games.run_int_TO_arrayInt(int_Recherche_NumberOfUnities, int_Scanner), new int[]{0, 0, 6, 6, 6, 6, 6, 6});

        int_Recherche_NumberOfUnities = 8;
        int_Scanner = 7777777;

        assertArrayEquals(utilities_Games.run_int_TO_arrayInt(int_Recherche_NumberOfUnities, int_Scanner), new int[]{0, 7, 7, 7, 7, 7, 7, 7});

        int_Recherche_NumberOfUnities = 8;
        int_Scanner = 88888888;

        assertArrayEquals(utilities_Games.run_int_TO_arrayInt(int_Recherche_NumberOfUnities, int_Scanner), new int[]{8, 8, 8, 8, 8, 8, 8, 8});

        int_Recherche_NumberOfUnities = 7;
        int_Scanner = 7777777;

        assertArrayEquals(utilities_Games.run_int_TO_arrayInt(int_Recherche_NumberOfUnities, int_Scanner), new int[]{7, 7, 7, 7, 7, 7, 7});

        int_Recherche_NumberOfUnities = 6;
        int_Scanner = 666666;

        assertArrayEquals(utilities_Games.run_int_TO_arrayInt(int_Recherche_NumberOfUnities, int_Scanner), new int[]{6, 6, 6, 6, 6, 6});

        int_Recherche_NumberOfUnities = 5;
        int_Scanner = 55555;

        assertArrayEquals(utilities_Games.run_int_TO_arrayInt(int_Recherche_NumberOfUnities, int_Scanner), new int[]{5, 5, 5, 5, 5});

        int_Recherche_NumberOfUnities = 4;
        int_Scanner = 4444;

        assertArrayEquals(utilities_Games.run_int_TO_arrayInt(int_Recherche_NumberOfUnities, int_Scanner), new int[]{4, 4, 4, 4});

        int_Recherche_NumberOfUnities = 3;
        int_Scanner = 333;

        assertArrayEquals(utilities_Games.run_int_TO_arrayInt(int_Recherche_NumberOfUnities, int_Scanner), new int[]{3, 3, 3});

        int_Recherche_NumberOfUnities = 2;
        int_Scanner = 22;

        assertArrayEquals(utilities_Games.run_int_TO_arrayInt(int_Recherche_NumberOfUnities, int_Scanner), new int[]{2, 2});

        int_Recherche_NumberOfUnities = 1;
        int_Scanner = 1;

        assertArrayEquals(utilities_Games.run_int_TO_arrayInt(int_Recherche_NumberOfUnities, int_Scanner), new int[]{1});
    }

    @Test
    public void run_array_ch_ComparisonResult() {

        Defense_Recherche defense_Recherche = new Defense_Recherche();

        int int_Recherche_NumberOfUnities = 8;

        ArrayList al_Recherche_Defense = new ArrayList();

        int array_int_Combination[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        al_Recherche_Defense.add(0, array_int_Combination);

        int array_int_LastInferior[] = new int[int_Recherche_NumberOfUnities];
        al_Recherche_Defense.add(1, array_int_LastInferior);

        int array_int_LastSuperior[] = new int[int_Recherche_NumberOfUnities];
        al_Recherche_Defense.add(2, array_int_LastSuperior);

        int array_int_ComputerProposal[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        al_Recherche_Defense.add(3, array_int_ComputerProposal);

        char[] array_ch_ComparisonResult = new char[int_Recherche_NumberOfUnities];
        al_Recherche_Defense.add(4, array_ch_ComparisonResult);

        al_Recherche_Defense = defense_Recherche.run_array_ch_ComparisonResult(int_Recherche_NumberOfUnities, al_Recherche_Defense);

        array_ch_ComparisonResult = (char[]) al_Recherche_Defense.get(4);

        assertArrayEquals(array_ch_ComparisonResult, new char[]{'=', '=', '=', '=', '=', '=', '=', '='});



        int_Recherche_NumberOfUnities = 8;

        array_int_Combination = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        al_Recherche_Defense.add(0, array_int_Combination);

        array_int_ComputerProposal = new int[]{0, 2, 4, 4, 3, 6, 8, 8};
        al_Recherche_Defense.add(3, array_int_ComputerProposal);

        al_Recherche_Defense = defense_Recherche.run_array_ch_ComparisonResult(int_Recherche_NumberOfUnities, al_Recherche_Defense);

        array_ch_ComparisonResult = (char[]) al_Recherche_Defense.get(4);

        assertArrayEquals(array_ch_ComparisonResult, new char[]{'-', '=', '+', '=', '-', '=', '+', '='});
    }

    @Test
    public void run_array_int_LastInferiorUpdate() {

        Defense_Recherche defense_Recherche = new Defense_Recherche();

        int int_Recherche_NumberOfUnities;

        int_Recherche_NumberOfUnities = 8;

        ArrayList al_Recherche_Defense = new ArrayList();

        int array_int_Combination[] = new int[int_Recherche_NumberOfUnities];
        al_Recherche_Defense.add(0, array_int_Combination);

        int array_int_LastInferior[] = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        al_Recherche_Defense.add(1, array_int_LastInferior);

        int array_int_LastSuperior[] = new int[int_Recherche_NumberOfUnities];
        al_Recherche_Defense.add(2, array_int_LastSuperior);

        int array_int_ComputerProposal[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        al_Recherche_Defense.add(3, array_int_ComputerProposal);

        char[] array_ch_ComparisonResult = new char[]{'-', '-', '-', '-', '=', '+', '+', '+'};
        al_Recherche_Defense.add(4, array_ch_ComparisonResult);

        al_Recherche_Defense = defense_Recherche.run_array_int_LastInferiorUpdate(int_Recherche_NumberOfUnities, al_Recherche_Defense);

        array_int_LastInferior = (int[]) al_Recherche_Defense.get(1);

        assertArrayEquals(array_int_LastInferior, new int[]{0, 0, 0, 0, 0, 6, 7, 8});
    }

    @Test
    public void run_array_int_LastSuperiorUpdate() {

        Defense_Recherche defense_Recherche = new Defense_Recherche();

        int int_Recherche_NumberOfUnities;

        int_Recherche_NumberOfUnities = 8;

        ArrayList al_Recherche_Defense = new ArrayList();

        int array_int_Combination[] = new int[int_Recherche_NumberOfUnities];
        al_Recherche_Defense.add(0, array_int_Combination);

        int array_int_LastInferior[] = new int[int_Recherche_NumberOfUnities];
        al_Recherche_Defense.add(1, array_int_LastInferior);

        int array_int_LastSuperior[] = new int[]{9, 9, 9, 9, 9, 9, 9, 9};
        al_Recherche_Defense.add(2, array_int_LastSuperior);

        int array_int_ComputerProposal[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        al_Recherche_Defense.add(3, array_int_ComputerProposal);

        char[] array_ch_ComparisonResult = new char[]{'-', '-', '-', '-', '=', '+', '+', '+'};
        al_Recherche_Defense.add(4, array_ch_ComparisonResult);

        al_Recherche_Defense = defense_Recherche.run_array_int_LastSuperiorUpdate(int_Recherche_NumberOfUnities, al_Recherche_Defense);

        array_int_LastSuperior = (int[]) al_Recherche_Defense.get(2);

        assertArrayEquals(array_int_LastSuperior, new int[]{1, 2, 3, 4, 9, 9, 9, 9});
    }

    @Test
    public void run_array_int_SecondTypeComputerProposal() {

        Defense_Recherche defense_Recherche = new Defense_Recherche();

        int int_Recherche_NumberOfUnities;

        int_Recherche_NumberOfUnities = 8;

        ArrayList al_Recherche_Defense = new ArrayList();

        int array_int_Combination[] = new int[int_Recherche_NumberOfUnities];
        al_Recherche_Defense.add(0, array_int_Combination);

        int array_int_LastInferior[] = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        al_Recherche_Defense.add(1, array_int_LastInferior);

        int array_int_LastSuperior[] = new int[]{9, 9, 9, 9, 9, 9, 9, 9};
        al_Recherche_Defense.add(2, array_int_LastSuperior);

        int array_int_ComputerProposal[] = new int[]{5, 5, 5, 5, 5, 5, 5, 5};
        al_Recherche_Defense.add(3, array_int_ComputerProposal);

        char[] array_ch_ComparisonResult = new char[]{'-', '-', '-', '-', '=', '+', '+', '+'};
        al_Recherche_Defense.add(4, array_ch_ComparisonResult);

        al_Recherche_Defense = defense_Recherche.run_array_int_SecondTypeComputerProposal(int_Recherche_NumberOfUnities, al_Recherche_Defense);

        array_int_ComputerProposal = (int[]) al_Recherche_Defense.get(3);

        assertArrayEquals(array_int_ComputerProposal, new int[]{3, 3, 3, 3, 5, 7, 7, 7});
    }
}