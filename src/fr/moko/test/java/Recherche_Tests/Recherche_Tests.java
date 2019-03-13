package java.Recherche_Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Mastermind_Test {

    @Test
    public void run_array_int_ComparisonResult(){

        Run_Mastermind run_mastermind = new Run_Mastermind();

        int int_NumberOfUnities = 8;

        int int_NumberOfLetters = 6;

        ArrayList al_Defense = new ArrayList();

        char array_ch_SelectedLetters[] = {'A', 'B', 'C', 'D', 'E', 'F'};
        al_Defense.add(0, array_ch_SelectedLetters);

        char array_ch_Combination[] = {'A', 'B', 'C', 'D', 'E', 'F', 'A', 'B'};
        al_Defense.add(1, array_ch_Combination);

        int array_int_NumberOfEachLettersInCombinason[] = {2, 2, 1, 1, 1, 1};
        al_Defense.add(2, array_int_NumberOfEachLettersInCombinason);

        char ch_NewLetter = ' ';
        al_Defense.add(3, ch_NewLetter);

        char array_ch_NewComputerProposal[] = {'A', 'B', 'C', 'D', 'E', 'F', 'A', 'B'};
        al_Defense.add(4, array_ch_NewComputerProposal);

        int array_int_PreviousComparisonResult[] = new int[3];
        al_Defense.add(5, array_int_PreviousComparisonResult);

        int array_int_NewComparisonResult[] = {0, 0, 0};
        al_Defense.add(6, array_int_NewComparisonResult);

        char array_ch_ComparisonOfComparisonResults[] = {'-', '-'};
        al_Defense.add(7, array_ch_ComparisonOfComparisonResults);

        boolean array_boo_FoundLetters[] = new boolean[int_NumberOfUnities];
        al_Defense.add(8, array_boo_FoundLetters);

        char array_ch_PresentLetters[] = new char[int_NumberOfUnities];
        al_Defense.add(9, array_ch_PresentLetters);

        boolean array_boo_PresentLetters[] = new boolean[int_NumberOfUnities];
        al_Defense.add(10, array_boo_PresentLetters);

        char array_ch_NotPresentLetters[] = new char[int_NumberOfUnities];
        al_Defense.add(11, array_ch_NotPresentLetters);

        assertArrayEquals(run_mastermind.run_array_int_ComparisonResult(int_NumberOfUnities, int_NumberOfLetters, al_Defense), new int[]{8, 0, 0});

        array_ch_SelectedLetters = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
        al_Defense.set(0, array_ch_SelectedLetters);

        array_ch_Combination = new char[]{'A', 'A', 'B', 'C', 'D', 'E', 'A', 'A'};
        al_Defense.set(1, array_ch_Combination);

        array_int_NumberOfEachLettersInCombinason = new int[]{2, 2, 1, 1, 1, 1};
        al_Defense.set(2, array_int_NumberOfEachLettersInCombinason);

        ch_NewLetter = ' ';
        al_Defense.add(3, ch_NewLetter);

        array_ch_NewComputerProposal = new char[]{'A', 'A', 'C', 'B', 'E', 'D', 'F', 'F'};
        al_Defense.add(4, array_ch_NewComputerProposal);

        array_int_NewComparisonResult = new int[]{0, 0, 0};
        al_Defense.set(6, array_int_NewComparisonResult);

        assertArrayEquals(run_mastermind.run_array_int_ComparisonResult(int_NumberOfUnities, int_NumberOfLetters, al_Defense), new int[]{2, 4, 2});
    }

    @Test
    public void run_ComparisonOfComparisonResults(){

        Run_Mastermind run_mastermind = new Run_Mastermind();

        int int_NumberOfUnities = 8;

        int int_NumberOfLetters = 6;

        ArrayList al_Defense = new ArrayList();

        char array_ch_SelectedLetters[] = new char[int_NumberOfLetters];
        al_Defense.add(0, array_ch_SelectedLetters);

        char array_ch_Combination[] = new char[int_NumberOfUnities];
        al_Defense.add(1, array_ch_Combination);

        int array_int_NumberOfEachLettersInCombinason[] = new int[int_NumberOfUnities];
        al_Defense.add(2, array_int_NumberOfEachLettersInCombinason);

        char array_ch_PreviousComputerProposal[] = new char[int_NumberOfUnities];
        al_Defense.add(3, array_ch_PreviousComputerProposal);

        char array_ch_NewComputerProposal[] = new char[int_NumberOfUnities];
        al_Defense.add(4, array_ch_NewComputerProposal);

        int array_int_PreviousComparisonResult[] = new int[]{7, 1, 0};
        al_Defense.add(5, array_int_PreviousComparisonResult);

        int array_int_NewComparisonResult[] = new int[]{8, 0, 0};
        al_Defense.add(6, array_int_NewComparisonResult);

        char array_ch_ComparisonOfComparisonResults[] = new char[2];
        al_Defense.add(7, array_ch_ComparisonOfComparisonResults);

        boolean array_boo_FoundLetters[] = new boolean[int_NumberOfUnities];
        al_Defense.add(8, array_boo_FoundLetters);

        assertArrayEquals(run_mastermind.run_ComparisonOfComparisonResults(al_Defense), new char[]{'=', '≠'});

        array_int_PreviousComparisonResult = new int[]{7, 0, 1};
        al_Defense.set(5, array_int_PreviousComparisonResult);

        array_int_NewComparisonResult = new int[]{8, 0, 0};
        al_Defense.set(6, array_int_NewComparisonResult);

        assertArrayEquals(run_mastermind.run_ComparisonOfComparisonResults(al_Defense), new char[]{'=', '-'});

        array_int_PreviousComparisonResult = new int[]{8, 0, 0};
        al_Defense.set(5, array_int_PreviousComparisonResult);

        array_int_NewComparisonResult = new int[]{7, 1, 0};
        al_Defense.set(6, array_int_NewComparisonResult);

        assertArrayEquals(run_mastermind.run_ComparisonOfComparisonResults(al_Defense), new char[]{'≠', '='});

        array_int_PreviousComparisonResult = new int[]{0, 0, 8};
        al_Defense.set(5, array_int_PreviousComparisonResult);

        array_int_NewComparisonResult = new int[]{0, 1, 7};
        al_Defense.set(6, array_int_NewComparisonResult);

        assertArrayEquals(run_mastermind.run_ComparisonOfComparisonResults(al_Defense), new char[]{'≠', '-'});

        array_int_PreviousComparisonResult = new int[]{1, 0, 7};
        al_Defense.set(5, array_int_PreviousComparisonResult);

        array_int_NewComparisonResult = new int[]{0, 0, 8};
        al_Defense.set(6, array_int_NewComparisonResult);

        assertArrayEquals(run_mastermind.run_ComparisonOfComparisonResults(al_Defense), new char[]{'-', '='});

        array_int_PreviousComparisonResult = new int[]{0, 1, 7};
        al_Defense.set(5, array_int_PreviousComparisonResult);

        array_int_NewComparisonResult = new int[]{0, 0, 8};
        al_Defense.set(6, array_int_NewComparisonResult);

        assertArrayEquals(run_mastermind.run_ComparisonOfComparisonResults(al_Defense), new char[]{'-', '≠'});

        array_int_PreviousComparisonResult = new int[]{0, 8, 0};
        al_Defense.set(5, array_int_PreviousComparisonResult);

        array_int_NewComparisonResult = new int[]{0, 8, 0};
        al_Defense.set(6, array_int_NewComparisonResult);

        assertArrayEquals(run_mastermind.run_ComparisonOfComparisonResults(al_Defense), new char[]{'-', '-'});
    }
}

