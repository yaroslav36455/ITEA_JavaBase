package ua.itea.lesson16.tasks;

public class Engine {
	private Field field;
	private Grass grassProto;
	private Dog dog;
	private Position pos;
	private final int stepHealthMod = -5;
	
	public Engine() {
		field = new Field(10, 10);
		grassProto = new Grass();
		
		reset();
	}
	
	public void reset() {
		Position bombPos;
		Position firstAidPos;
		IntGenerator gen = new IntGenerator(new ClosedIntRange(1, field.getWidth()));
		
		dog = new Dog(100);
		pos = new Position(1, 1);
		
		/* fill field with grass */
		grassProto = new Grass();
		for (int y = 1; y <= field.getHeight(); y++) {
			for (int x = 1; x <= field.getWidth(); x++) {
				field.getCell(x, y).setItem(grassProto);
			}
		}
		
		/* fill first line */
		field.getCell(pos).setItem(dog);
		bombPos = new Position(gen.generateExcept(pos.getX()), pos.getY());
		firstAidPos = new Position(gen.generateExcept(pos.getX(), bombPos.getX()), pos.getY());
		field.getCell(bombPos).setItem(new Bomb());
		field.getCell(firstAidPos).setItem(new FirstAid());
		
		/* fill lines (1; field.getHeight()] */
		for (int i = 2; i <= field.getHeight(); i++) {
			bombPos = new Position(gen.generateExcept(), i);
			firstAidPos = new Position(gen.generateExcept(bombPos.getX()), i);
			
			field.getCell(bombPos).setItem(new Bomb());
			field.getCell(firstAidPos).setItem(new FirstAid());
		}
	}
	
	public void move(Direction dir) {
		Position newPos = null;
		
		switch (dir) {
		case LEFT:
			newPos = new Position(pos.getX() - 1, pos.getY());
			break;
			
		case RIGHT:
			newPos = new Position(pos.getX() + 1, pos.getY());
			break;
			
		case UP:
			newPos = new Position(pos.getX(), pos.getY() - 1);
			break;
			
		case DOWN:
			newPos = new Position(pos.getX(), pos.getY() + 1);
			break;

		default:
			break;
		}
		
		if (field.isWithin(newPos)) {
			makeStep(newPos);
		}
	}
	
	public boolean isGameOver() {
		return !dog.isAlive();
	}
	
	private void makeStep(Position newPos) {
		if (isGameOver()) {
			return;
		}
		
		int itemHealthMod = field.getCell(newPos).getItem().getHealthMod();

		dog.setHealth(dog.getHealth() + stepHealthMod + itemHealthMod);
		
		field.getCell(pos).setItem(grassProto);
		field.getCell(newPos).setItem(dog);
		pos = newPos;
	}

	public int getFieldWidth() {
		return field.getWidth();
	}
	
	public int getFieldHeight() {
		return field.getHeight();
	}
	
	/**
	 * @param x - coordinate from left to right [1; Integer.MAX_VALUE]
	 * @param y - coordinate from top to bottom [1; Integer.MAX_VALUE]
	 * @return ItemId
	 */
	public ItemId getItemId(int x, int y) {
		return field.getCell(x, y).getItem().getId();
	}
	
	public ItemId getItemId(Position pos) {
		return field.getCell(pos).getItem().getId();
	}
	
	public int getDogHealth() {
		return dog.getHealth();
	}
}
