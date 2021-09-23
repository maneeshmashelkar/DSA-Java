package stackAndQueueQuestions;

import java.util.LinkedList;

public class AnimalShelter {

	LinkedList<Dog> dogs = new LinkedList<>();
	LinkedList<Cat> cats = new LinkedList<>();
	private int order = 0;

	// enqueue
	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		if (a instanceof Dog) {
			dogs.addLast((Dog) a);
		} else if (a instanceof Cat) {
			cats.addLast((Cat) a);
		}
	}

	// size
	public int size() {
		return dogs.size() + cats.size();
	}

	// dequeue dogs
	public Dog dequeueDog() {
		return dogs.poll();
	}

	// peek dogs
	public Dog peekDog() {
		return dogs.peek();
	}

	// dequeue cats
	public Cat dequeueCat() {
		return cats.poll();
	}

	// peek cats
	public Cat peekCat() {
		return cats.peek();
	}

	// dequeue any
	public Animal dequeueAny() {
		if (dogs.size() == 0) {
			return dequeueDog();
		} else if (cats.size() == 0) {
			return dequeueCat();
		}

		Dog dog = dogs.peek();
		Cat cat = cats.peek();

		if (dog.isOlderThan(cat)) {
			return dogs.poll();
		} else {
			return cats.poll();
		}
	}

	// peek any
	public Animal peekAny() {
		if (dogs.size() == 0) {
			return peekDog();
		} else if (cats.size() == 0) {
			return peekCat();
		}

		Dog dog = dogs.peek();
		Cat cat = cats.peek();

		if (dog.isOlderThan(cat)) {
			return dogs.peek();
		} else {
			return cats.peek();
		}
	}

	public static void main(String[] args) {
		
		AnimalShelter a = new AnimalShelter();
		
		a.enqueue(new Cat("a"));
		a.enqueue(new Dog("b"));
		a.enqueue(new Cat("c"));
		a.enqueue(new Dog("d"));
		a.enqueue(new Dog("e"));
		a.enqueue(new Cat("f"));
		
		System.out.println(a.dequeueCat().name);
		System.out.println(a.dequeueAny().name);
		System.out.println(a.dequeueDog().name);
		
		System.out.println(a.peekDog().name);
		System.out.println(a.peekAny().name);
		System.out.println(a.peekCat().name);
	}	

}
