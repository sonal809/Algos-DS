package code;

public class ExcelColumn {
	
	public String colValue(int n) {
		System.out.println(n);
        return n == 0 ? "" : colValue(--n / 26) + (char)('A' + (n % 26));

	}
	public static void main(String args[]) {
		ExcelColumn ex = new ExcelColumn();
//		System.out.println(ex.colValue(2));
//		System.out.println(ex.colValue(28));
//		System.out.println(ex.colValue(26));
//		System.out.println(ex.colValue(27));
//
//		System.out.println(ex.colValue(701));
		System.out.println(ex.colValue(52));



		
	}
}
