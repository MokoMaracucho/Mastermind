package java.mastermind_Tests;

import fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind.Defense_Mastermind;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class Mastermind_Tests {

    @Test
    public void run_al_NewComparisonResult(){

        Defense_Mastermind defense_Mastermind = new Defense_Mastermind();

        int int_Mastermind_NumberOfUnities = 8;

        int int_Mastermind_NumberOfLetters = 6;

        String str_Sub_Mode = "Challenger";

        ArrayList al_Mastermind_Defense = new ArrayList();

        char array_ch_SelectedLetters[] = {'A', 'B', 'C', 'D', 'E', 'F'};
        al_Mastermind_Defense.add(0, array_ch_SelectedLetters);

        char array_ch_Combination[] = {'A', 'B', 'C', 'D', 'E', 'F', 'A', 'B'};
        al_Mastermind_Defense.add(1, array_ch_Combination);

        int array_int_NumberOfEachLettersInCombinason[] = {2, 2, 1, 1, 1, 1};
        al_Mastermind_Defense.add(2, array_int_NumberOfEachLettersInCombinason);

        char ch_NewLetter = ' ';
        al_Mastermind_Defense.add(3, ch_NewLetter);

        char array_ch_NewComputerProposal[] = {'A', 'B', 'C', 'D', 'E', 'F', 'A', 'B'};
        al_Mastermind_Defense.add(4, array_ch_NewComputerProposal);

        int array_int_PreviousComparisonResult[] = new int[3];
        al_Mastermind_Defense.add(5, array_int_PreviousComparisonResult);

        int array_int_NewComparisonResult[] = {0, 0, 0};
        al_Mastermind_Defense.add(6, array_int_NewComparisonResult);

        char array_ch_ComparisonOfComparisonResults[] = {'-', '-'};
        al_Mastermind_Defense.add(7, array_ch_ComparisonOfComparisonResults);

        boolean array_boo_FoundLetters[] = new boolean[int_Mastermind_NumberOfUnities];
        al_Mastermind_Defense.add(8, array_boo_FoundLetters);

        char array_ch_PresentLetters[] = new char[int_Mastermind_NumberOfUnities];
        al_Mastermind_Defense.add(9, array_ch_PresentLetters);

        boolean array_boo_PresentLetters[] = new boolean[int_Mastermind_NumberOfUnities];
        al_Mastermind_Defense.add(10, array_boo_PresentLetters);

        char array_ch_NotPresentLetters[] = new char[int_Mastermind_NumberOfUnities];
        al_Mastermind_Defense.add(11, array_ch_NotPresentLetters);

        array_int_NewComparisonResult = defense_Mastermind.run_al_NewComparisonResult(int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, str_Sub_Mode, al_Mastermind_Defense);

        assertArrayEquals(array_int_NewComparisonResult, new int[]{8, 0, 0});



        array_ch_SelectedLetters = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
        al_Mastermind_Defense.set(0, array_ch_SelectedLetters);

        array_ch_Combination = new char[]{'A', 'A', 'B', 'C', 'D', 'E', 'A', 'A'};
        al_Mastermind_Defense.set(1, array_ch_Combination);

        array_int_NumberOfEachLettersInCombinason = new int[]{2, 2, 1, 1, 1, 1};
        al_Mastermind_Defense.set(2, array_int_NumberOfEachLettersInCombinason);

        ch_NewLetter = ' ';
        al_Mastermind_Defense.add(3, ch_NewLetter);

        array_ch_NewComputerProposal = new char[]{'A', 'A', 'C', 'B', 'E', 'D', 'F', 'F'};
        al_Mastermind_Defense.add(4, array_ch_NewComputerProposal);

        array_int_NewComparisonResult = new int[]{0, 0, 0};
        al_Mastermind_Defense.set(6, array_int_NewComparisonResult);

        array_int_NewComparisonResult = defense_Mastermind.run_al_NewComparisonResult(int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, str_Sub_Mode, al_Mastermind_Defense);

        assertArrayEquals(array_int_NewComparisonResult, new int[]{2, 4, 2});
    }



    @Test
    public void run_ComparisonOfComparisonResults(){

        Defense_Mastermind defense_Mastermind = new Defense_Mastermind();

        int int_Mastermind_NumberOfUnities = 8;

        int int_Mastermind_NumberOfLetters = 6;

        ArrayList al_Mastermind_Defense = new ArrayList();

        char array_ch_SelectedLetters[] = new char[int_Mastermind_NumberOfLetters];
        al_Mastermind_Defense.add(0, array_ch_SelectedLetters);

        char array_ch_Combination[] = new char[int_Mastermind_NumberOfUnities];
        al_Mastermind_Defense.add(1, array_ch_Combination);

        int array_int_NumberOfEachLettersInCombinason[] = new int[int_Mastermind_NumberOfUnities];
        al_Mastermind_Defense.add(2, array_int_NumberOfEachLettersInCombinason);

        char array_ch_PreviousComputerProposal[] = new char[int_Mastermind_NumberOfUnities];
        al_Mastermind_Defense.add(3, array_ch_PreviousComputerProposal);

        char array_ch_NewComputerProposal[] = new char[int_Mastermind_NumberOfUnities];
        al_Mastermind_Defense.add(4, array_ch_NewComputerProposal);

        int array_int_PreviousComparisonResult[] = new int[]{7, 1, 0};
        al_Mastermind_Defense.add(5, array_int_PreviousComparisonResult);

        int array_int_NewComparisonResult[] = new int[]{8, 0, 0};
        al_Mastermind_Defense.add(6, array_int_NewComparisonResult);

        char array_ch_ComparisonOfComparisonResults[] = new char[2];
        al_Mastermind_Defense.add(7, array_ch_ComparisonOfComparisonResults);

        boolean array_boo_FoundLetters[] = new boolean[int_Mastermind_NumberOfUnities];
        al_Mastermind_Defense.add(8, array_boo_FoundLetters);

        al_Mastermind_Defense = defense_Mastermind.run_al_ComparisonOfComparisonResults(al_Mastermind_Defense);

        array_ch_ComparisonOfComparisonResults = (char[]) al_Mastermind_Defense.get(8);

        assertArrayEquals(array_ch_ComparisonOfComparisonResults, new char[]{'=', '≠'});

        array_int_PreviousComparisonResult = new int[]{7, 0, 1};
        al_Mastermind_Defense.set(5, array_int_PreviousComparisonResult);

        array_int_NewComparisonResult = new int[]{8, 0, 0};
        al_Mastermind_Defense.set(6, array_int_NewComparisonResult);

        al_Mastermind_Defense = defense_Mastermind.run_al_ComparisonOfComparisonResults(al_Mastermind_Defense);

        array_ch_ComparisonOfComparisonResults = (char[]) al_Mastermind_Defense.get(8);

        assertArrayEquals(array_ch_ComparisonOfComparisonResults, new char[]{'=', '-'});

        array_int_PreviousComparisonResult = new int[]{8, 0, 0};
        al_Mastermind_Defense.set(5, array_int_PreviousComparisonResult);

        array_int_NewComparisonResult = new int[]{7, 1, 0};
        al_Mastermind_Defense.set(6, array_int_NewComparisonResult);

        al_Mastermind_Defense = defense_Mastermind.run_al_ComparisonOfComparisonResults(al_Mastermind_Defense);

        array_ch_ComparisonOfComparisonResults = (char[]) al_Mastermind_Defense.get(8);

        assertArrayEquals(array_ch_ComparisonOfComparisonResults, new char[]{'≠', '='});

        array_int_PreviousComparisonResult = new int[]{0, 0, 8};
        al_Mastermind_Defense.set(5, array_int_PreviousComparisonResult);

        array_int_NewComparisonResult = new int[]{0, 1, 7};
        al_Mastermind_Defense.set(6, array_int_NewComparisonResult);

        al_Mastermind_Defense = defense_Mastermind.run_al_ComparisonOfComparisonResults(al_Mastermind_Defense);

        array_ch_ComparisonOfComparisonResults = (char[]) al_Mastermind_Defense.get(8);

        assertArrayEquals(array_ch_ComparisonOfComparisonResults, new char[]{'≠', '-'});

        array_int_PreviousComparisonResult = new int[]{1, 0, 7};
        al_Mastermind_Defense.set(5, array_int_PreviousComparisonResult);

        array_int_NewComparisonResult = new int[]{0, 0, 8};
        al_Mastermind_Defense.set(6, array_int_NewComparisonResult);

        al_Mastermind_Defense = defense_Mastermind.run_al_ComparisonOfComparisonResults(al_Mastermind_Defense);

        array_ch_ComparisonOfComparisonResults = (char[]) al_Mastermind_Defense.get(8);

        assertArrayEquals(array_ch_ComparisonOfComparisonResults, new char[]{'-', '='});

        array_int_PreviousComparisonResult = new int[]{0, 1, 7};
        al_Mastermind_Defense.set(5, array_int_PreviousComparisonResult);

        array_int_NewComparisonResult = new int[]{0, 0, 8};
        al_Mastermind_Defense.set(6, array_int_NewComparisonResult);

        al_Mastermind_Defense = defense_Mastermind.run_al_ComparisonOfComparisonResults(al_Mastermind_Defense);

        array_ch_ComparisonOfComparisonResults = (char[]) al_Mastermind_Defense.get(8);

        assertArrayEquals(array_ch_ComparisonOfComparisonResults, new char[]{'-', '≠'});

        array_int_PreviousComparisonResult = new int[]{0, 8, 0};
        al_Mastermind_Defense.set(5, array_int_PreviousComparisonResult);

        array_int_NewComparisonResult = new int[]{0, 8, 0};
        al_Mastermind_Defense.set(6, array_int_NewComparisonResult);

        al_Mastermind_Defense = defense_Mastermind.run_al_ComparisonOfComparisonResults(al_Mastermind_Defense);

        array_ch_ComparisonOfComparisonResults = (char[]) al_Mastermind_Defense.get(8);

        assertArrayEquals(array_ch_ComparisonOfComparisonResults, new char[]{'-', '-'});
    }
}