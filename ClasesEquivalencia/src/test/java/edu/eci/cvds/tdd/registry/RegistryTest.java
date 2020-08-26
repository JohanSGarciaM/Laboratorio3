package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateDuplicate() {
        Person person = new Person("Steven",1234,23,Gender.MALE,true);
        Person person2 = new Person("Steven",1234,23,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);
        RegisterResult result2 = registry.registerVoter(person2);

        Assert.assertEquals(RegisterResult.DUPLICATED, result2);
    }

    @Test
    public void validateDead(){
        Person person = new Person("Carlos",2345,20,Gender.MALE,false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD,result);
    }

    @Test
    public void validateUnderage(){
        Person person = new Person("Paola",3456,16,Gender.FEMALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE,result);
    }

    @Test
    public void validateInvalidage(){
        Person person = new Person("Camila",4567,140,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE,result);
    }   

    @Test
    public void validateMustbeDisjoint(){
        Person person = new Person("Franco",4567,-12,Gender.MALE,false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD,result);
    }
}