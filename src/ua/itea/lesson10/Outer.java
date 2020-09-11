package ua.itea.lesson10;

public class Outer {
	public String outerPublic = "outerPublic";
	private String outerPrivate = "outerPrivate";
	private static String outerField = "outerField";
	
	public Outer() {
		Inner inner = new Inner();
		inner.methodInnerPublic();
		
		Nested nested = new Nested();
		nested.methodNestedPublic();
		
		String str = Nested.nestedField;
	}
	
	public void methodOuterPublic() {
		
	}
	
	private void methodOuterPrivate() {
		
	}
	
	public class Inner {
		public String innerPublic = "innerPublic";
		private String innerPrivate = "innerPrivate";
		
		public void methodInnerPublic() {
			System.out.println(outerPublic);
			System.out.println(outerPrivate);
		}
		
		private void methodInnerPrivate() {
			
		}
	}
	
	public static class Nested {
		public String nestedPublic = "nestedPublic";
		private String nestedPrivate = "nestedPrivate";
		public static String nestedField = "nestedField";
		
		public void methodNestedPublic() {
//			System.out.println(outerPublic);
//			System.out.println(outerPrivate);
			System.out.println(outerField);
		}
		
		private void methodNestedPrivate() {
			
		}
	}
}
