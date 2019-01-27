import org.junit.Test;

import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;

    public class BirthNumberTest {
        List<PersonInfo> testCases = getTestCases();


        private List<PersonInfo> getTestCases() {
            List<PersonInfo> cases = new LinkedList<PersonInfo>();
            cases.add(new PersonInfo("21099649949").setMale().yearOfBirth("1996").monthOfBirth("09").dayOfBirth("21"));
            cases.add(new PersonInfo("01088049620").setFemale().yearOfBirth("1980").monthOfBirth("08").dayOfBirth("01"));
            cases.add(new PersonInfo("31120894539").setMale().yearOfBirth("2008").monthOfBirth("12").dayOfBirth("31"));
            cases.add(new PersonInfo("01129462406").setFemale().yearOfBirth("1894").monthOfBirth("12").dayOfBirth("01"));
            cases.add(new PersonInfo("01129462407").setFemale().yearOfBirth("1894").monthOfBirth("12").dayOfBirth("01").setInvalid());
            cases.add(new PersonInfo("ttt").setInvalid());
            return cases;
        }

        private String Msg(int testCaseNumber) {
            return String.format("Failed[%d]", testCaseNumber);
        }


        @Test
        public void runTestCases() throws Exception {
            for (PersonInfo testCase : testCases) {
                int testCaseNumber = testCases.indexOf(testCase);
                if (testCase.isInvalid()) {
                    try {
                        BirthNumber.valueOf(testCase.getBirthNumber());
                        fail(Msg(testCaseNumber));
                    } catch (IllegalArgumentException e) {
                        ;
                    }
                } else {
                    BirthNumber fNr = BirthNumber.valueOf(testCase.getBirthNumber());
                    assertEquals(Msg(testCaseNumber), testCase.isMale(), fNr.isMale());
                    assertEquals(Msg(testCaseNumber), testCase.getBirthNumber(), fNr.toString());
                    assertEquals(Msg(testCaseNumber), testCase.getYear4Digits(), fNr.getBirthYear4Digit());
                    assertEquals(Msg(testCaseNumber), testCase.getYear2Digits(), fNr.getBirthYear2Digit());
                    assertEquals(Msg(testCaseNumber), testCase.getMonth(), fNr.getMonth());
                    assertEquals(Msg(testCaseNumber), testCase.getDay(), fNr.getDay());
                }
            }
        }

    }





