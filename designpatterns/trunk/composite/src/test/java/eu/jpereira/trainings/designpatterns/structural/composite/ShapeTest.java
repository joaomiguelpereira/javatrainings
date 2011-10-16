/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.structural.composite;

import java.util.List;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.structural.composite.model.Circle;
import eu.jpereira.trainings.designpatterns.structural.composite.model.Line;
import eu.jpereira.trainings.designpatterns.structural.composite.model.Rectangle;
import eu.jpereira.trainings.designpatterns.structural.composite.model.Shape;
import eu.jpereira.trainings.designpatterns.structural.composite.model.ShapeDoesNotSupportChildren;
import eu.jpereira.trainings.designpatterns.structural.composite.model.ShapeType;
import eu.jpereira.trainings.designpatterns.structural.composite.model.Triangle;
import static org.junit.Assert.*;

/**
 * @author jpereira
 * 
 */
public class ShapeTest {

	@Test
	public void testAddShape() throws ShapeDoesNotSupportChildren {

		// Create a circle
		Shape circle = new Circle();
		// Create a line
		Shape line = new Line();
		Shape rectangle = new Rectangle();
		Shape triangle = new Triangle();

		// Add a line to the circle
		circle.asComposite().addShape(line);
		// add a rectangle to a circle
		circle.asComposite().addShape(rectangle);
		circle.asComposite().addShape(triangle);

		// assert circle has three children
		assertEquals(3, circle.asComposite().getShapeCount());

	}

	@Test
	public void testGetShapesByTye() {
		Shape shape = createCompositeShapeFixture();
		// Assert it contains RECTANGLE (well, I know that fixture...)
		assertNotNull(shape.asComposite().getShapesByType(ShapeType.RECTANGLE));
		assertEquals(1, shape.asComposite().getShapesByType(ShapeType.RECTANGLE).size());

	}

	@Test
	public void testRemoveShape() {

		Shape shape = createCompositeShapeFixture();
		// Assert it contains RECTANGLE (well, I know that fixture...)
		assertEquals(1, shape.asComposite().getShapesByType(ShapeType.RECTANGLE).size());

		// Now remove it
		assertTrue(shape.asComposite().removeShape(shape.asComposite().getShapesByType(ShapeType.RECTANGLE).get(0)));
		assertEquals(0, shape.asComposite().getShapesByType(ShapeType.RECTANGLE).size());
	}

	@Test
	public void testMoveShape() {
		Shape testShape = createCompositeShapeFixture();
		//Move a the shape
		testShape.move(2, 2);
		assertEquals(2,testShape.getX());
		assertEquals(2, testShape.getY());
		
		//each shape in the tree has to move also
		for (Shape aShape: testShape.asComposite().getShapes() ) {
			assertEquals(2, aShape.getX());
			assertEquals(2, aShape.getY());
		}
	}
	
	@Test
	public void testMoveLeafsShapes() {
		Shape testShape = createCompositeShapeFixture();
		
		assertEquals(0, testShape.getX());
		assertEquals(0, testShape.getY());
		//Get all primitives
		List<Shape> leafs = testShape.asComposite().getLeafShapes();
		
		for (Shape leaf : leafs ) {
			leaf.move(2, 2);
			assertEquals(2, leaf.getX());
			assertEquals(2, leaf.getY());
		}
		assertEquals(0, testShape.getX());
		assertEquals(0, testShape.getY());
	}
	
	@Test
	public void moveHierarchyIndependently() {
		
		Shape rectangle = new Rectangle();
		//inside the rectangle, has a circle and another rectangle
		Shape innerRectangle = new Rectangle();
		Shape innerCircle = new Circle();
		rectangle.asComposite().addShape(innerCircle);
		rectangle.asComposite().addShape(innerRectangle);
		//inside the innerRectangle, add  two lines
		Shape innerInnerlineA = new Line();
		Shape innerInnerlineB = new Line();
		innerRectangle.asComposite().addShape(innerInnerlineA);
		innerRectangle.asComposite().addShape(innerInnerlineB);
		//inside the innerCircle add a triangle
		Shape innerInnerTriangle = new Triangle();
		innerCircle.asComposite().addShape(innerInnerTriangle);
		//inside the innerInnerTriagle let's add a line
		Shape innerInnerInnerLine = new Line();
		innerInnerTriangle.asComposite().addShape(innerInnerInnerLine);
		
		
		
		//Move the rectangle all together
		rectangle.move(3, 3);
		//rectangle still have the same position
		assertEquals(3, rectangle.getX());
		assertEquals(3, rectangle.getY());

		for ( Shape aShape : rectangle.asComposite().getShapes() ) {
			assertEquals(3, aShape.getX());
			assertEquals(3, aShape.getY());
		}
		
		//Move only the innerCircle
		innerCircle.move(1, 1);
		//innerRectangle still have the same position
		assertEquals(3, innerRectangle.getX());
		assertEquals(3, innerRectangle.getY());

		//innerCircle and all children must have moved
		assertEquals(4,innerCircle.getX());
		assertEquals(4,innerCircle.getY());
		//all children has to move
		assertEquals(4, innerInnerTriangle.getX());
		assertEquals(4, innerInnerTriangle.getY());
		
		assertEquals(4, innerInnerInnerLine.getY());
		assertEquals(4, innerInnerInnerLine.getX());
		
	}
	/**
	 * Factory method for composite fixture
	 * @return
	 */
	protected Shape createCompositeShapeFixture() {
		// Create a circle
		Shape circle = new Circle();
		// Create a line
		Shape line = new Line();
		Shape rectangle = new Rectangle();
		Shape triangle = new Triangle();

		// Add a line to the circle
		circle.asComposite().addShape(line);
		// add a rectangle to a circle
		circle.asComposite().addShape(rectangle);
		circle.asComposite().addShape(triangle);
		return circle;
	}

	
	
}
