package Interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Employee {
	String name;
	int count;
	String email;
	Employee(String s) {
		this.name = s;
	}
	public void increaseCount() {
		this.count += 1; 
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
public class Lighthouse {
	//Name is . separated FN and LN.Eg. john.doe
	private String getEmail(String name, String company, int count) {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		if (count > 1) {
			sb.append(count);			
		}
		sb.append("@").append(company.toLowerCase()).append(".com");
		return sb.toString();
	}
	
	public String solution(String S, String C) {
		Map<String, List<Employee>> hm = new HashMap<String, List<Employee>>();
		Map<String, String> actualNameMap = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        String[] words = S.split(";");
        for(String s: words) {
            String[] nameParts = s.trim().split("\\s+");
            String name = nameParts[0].toLowerCase() + "." + nameParts[nameParts.length -1].toLowerCase().replaceAll("-", "");
            Employee emp = new Employee(s);
            actualNameMap.put(s, name);
            if (hm.containsKey(name)) {
                String email = getEmail(name, C, hm.get(name).size() + 1);
                System.out.println(name+ "   "+ email);
                emp.setEmail(email);
                hm.get(name).add(emp);
            } else {
                String email = getEmail(name, C, 1);
                System.out.println(name+ "   "+ email);
                emp.setEmail(email);
                List<Employee> empList = new ArrayList<>();
                empList.add(emp);
                hm.put(name,empList);
            }
        }
        
        for (String name: actualNameMap.keySet()) {
        	String emailName = actualNameMap.get(name);
        	List<Employee> employees = hm.get(emailName);
        	for (Employee emp : employees) {
        		if (emp.name.equals(name)) {
        			sb.append(name).append(" ").append("<").append(emp.email).append(">; ");
        		}
        	}
        }
        sb.setLength(sb.length()-2);
        return sb.toString();
    }
	
	
	public static void main(String args[]) {
		Lighthouse lt = new Lighthouse();
		String name = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
		System.out.println(lt.solution(name, "yahoo"));
	}
}
