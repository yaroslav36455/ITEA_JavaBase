package ua.itea.lesson15.tasks;

import ua.itea.lesson15.tasks.shape.Shape;

public class ShapeContainer {
	
	public int size() {
		throw new RuntimeException("Unimplemented method 'size()'"
				   				   + " in class ShapeContainer");
	}
	
	public void add(Shape shape, Shape ...shapes) {
		throw new RuntimeException("Unimplemented method 'add(Shape shape, Shape ...shapes)'"
				                   + " in class ShapeContainer");
	}
	
	public void add(ShapeContainer container, ShapeContainer ...containers) {
		throw new RuntimeException("Unimplemented method 'add(ShapeContainer container, ShapeContainer ...containers)'"
				   				   + " in class ShapeContainer");
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public Shape[] getShapes() {
		throw new RuntimeException("Unimplemented method 'getShapes()'"
				   				   + " in class ShapeContainer");
	}
	
	public String toString() {
		if(isEmpty()) {
			return "No shapes";
		} else {
			StringBuffer result = new StringBuffer();
			int counter = 1;
			
			result.append("┏━┯━━━━━━━━━┯━━━━━━━━━┯━━━━━━━━━┯━━━━━━┓\n");
			result.append("┃№│Shape    │Perimeter│Area     │Color ┃\n");
			result.append("┠─┼─────────┼─────────┼─────────┼──────┨\n");

			for (Shape shape : getShapes()) {
				result.append(String.format("┃%d│%-9s│%.3e│%.3e│%-6s┃%n",
											counter++,
								  	  		shape.getName(),
								  	  		shape.getPerimeter(),
								  	  		shape.getArea(),
								  	  		shape.getColor()));
			}

			result.append("┗━┷━━━━━━━━━┷━━━━━━━━━┷━━━━━━━━━┷━━━━━━┛");

			result.trimToSize();
			return result.toString();
		}
	}
}
