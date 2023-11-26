package gt.com.archteam.practice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RomanNumeralsShould {
    @Test
    public void return_i_when_number_is_1() {
        assertEquals("I", RomanNumerals.arabicToRoman(1));
    }

    @Test
    public void return_ii_when_number_is_2() {
        assertEquals("II", RomanNumerals.arabicToRoman(2));
    }

    @Test
    public void return_iii_when_number_is_3() {
        assertEquals("III", RomanNumerals.arabicToRoman(3));
    }

    @Test
    public void return_v_when_number_is_5() {
        assertEquals("V", RomanNumerals.arabicToRoman(5));
    }

    @Test
    public void return_vi_when_number_is_6() {
        assertEquals("VI", RomanNumerals.arabicToRoman(6));
    }

    @Test
    public void return_vii_when_number_is_7() {
        assertEquals("VII", RomanNumerals.arabicToRoman(7));
    }

    @Test
    public void return_x_when_number_is_10() {
        assertEquals("X", RomanNumerals.arabicToRoman(10));
    }

    @Test
    public void return_xi_when_number_is_11() {
        assertEquals("XI", RomanNumerals.arabicToRoman(11));
    }

    @Test
    public void return_xv_when_number_is_15() {
        assertEquals("XV", RomanNumerals.arabicToRoman(15));
    }

    @Test
    public void return_xvi_when_number_is_16() {
        assertEquals("XVI", RomanNumerals.arabicToRoman(16));
    }

    @Test
    public void return_l_when_number_is_50() {
        assertEquals("L", RomanNumerals.arabicToRoman(50));
    }

    @Test
    public void return_li_when_number_is_51() {
        assertEquals("LI", RomanNumerals.arabicToRoman(51));
    }

    @Test
    public void return_lv_when_number_is_55() {
        assertEquals("LV", RomanNumerals.arabicToRoman(55));
    }

    @Test
    public void return_lvi_when_number_is_56() {
        assertEquals("LVI", RomanNumerals.arabicToRoman(56));
    }

    @Test
    public void return_lx_when_number_is_60() {
        assertEquals("LX", RomanNumerals.arabicToRoman(60));
    }

    @Test
    public void return_lxx_when_number_is_70() {
        assertEquals("LXX", RomanNumerals.arabicToRoman(70));
    }

    @Test
    public void return_lxxx_when_number_is_80() {
        assertEquals("LXXX", RomanNumerals.arabicToRoman(80));
    }

    @Test
    public void return_lxxxi_when_number_is_81() {
        assertEquals("LXXXI", RomanNumerals.arabicToRoman(81));
    }

    @Test
    public void return_lxxxv_when_number_is_85() {
        assertEquals("LXXXV", RomanNumerals.arabicToRoman(85));
    }

    @Test
    public void return_lxxxvi_when_number_is_86() {
        assertEquals("LXXXVI", RomanNumerals.arabicToRoman(86));
    }

    @Test
    public void return_cxxvi_when_number_is_126() {
        assertEquals("CXXVI", RomanNumerals.arabicToRoman(126));
    }

    @Test
    public void return_mmdvii_when_number_is_2507() {
        assertEquals("MMDVII", RomanNumerals.arabicToRoman(2507));
    }
}
