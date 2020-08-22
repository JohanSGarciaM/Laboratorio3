package edu.eci.cvds.tdd.registry;

import java.util.*;
public class Registry {
	ArrayList<Person> personas = new ArrayList<Person>();
	
	public RegisterResult registerVoter(Person p){
		if(personas.size()==0){
			return elquequiera(p);
		}else{
			for(Person pe:personas){
				if(pe.getId()!= p.getId()){
					return elquequiera(p);
				}else{
					return RegisterResult.DUPLICATED;
				}
			}
		}
		return RegisterResult.VALID;
    }
	private RegisterResult elquequiera(Person p){
		if(p.isAlive()){
			if(p.getAge()>0 & p.getAge()<120){
				if(p.getAge()>=18){
					personas.add(p);
					return RegisterResult.VALID;
				}else{
					return RegisterResult.UNDERAGE;
				}
			}else{
				return RegisterResult.INVALID_AGE;
			}
		}else{
			return RegisterResult.DEAD;
		}
	}
}