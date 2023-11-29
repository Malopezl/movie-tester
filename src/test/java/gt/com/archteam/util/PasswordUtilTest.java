package gt.com.archteam.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PasswordUtilTest {

    @Test
    public void weak_when_has_less_than_8_letters() {
        assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("1234aa!"));
    }

    @Test
    public void weak_when_has_only_letters() {
        assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("abcdefgh"));
    }

    @Test
    public void medium_when_has_letters_and_numbers() {
        assertEquals(PasswordUtil.SecurityLevel.MEDIUM, PasswordUtil.assessPassword("abcd1234"));
    }

    @Test
    public void medium_when_has_letters_and_numbers_and_symbols() {
        assertEquals(PasswordUtil.SecurityLevel.STRONG, PasswordUtil.assessPassword("abcd1234!"));
    }

}
