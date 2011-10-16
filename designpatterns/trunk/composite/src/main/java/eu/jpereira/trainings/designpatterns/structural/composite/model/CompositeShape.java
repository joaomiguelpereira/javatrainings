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
package eu.jpereira.trainings.designpatterns.structural.composite.model;

import java.util.ArrayList;
import java.util.List;

import eu.jpereira.trainings.designpatterns.structural.composite.ShapeType;

/**
 * @author João Pereira
 * 
 */
public abstract class CompositeShape extends Shape {

	// Children shapes
	private List<Shape> shapes;

	public CompositeShape() {
		this.shapes = createShapesList();
	}

	

	/**
	 * Remove a shape from this shape childrens
	 * 
	 * @param shape
	 *            the shape to remove
	 * @return true if the shape was present and was removed, false if the shape
	 *         was not present
	 */
	public boolean removeShape(Shape shape) {
		boolean shapePresent = false;
		if ( this.shapes.contains(shape)) {
			this.shapes.remove(shape);
			shapePresent = true;
		}
		return shapePresent;
	}

	/**
	 * Return the total shapes count in case this is a composite
	 * 
	 * @return the total count of shapes if the shape is composite. -1 otherwise
	 */
	public int getShapeCount() {
		return this.getShapes().size();
	}

	/**
	 * Add a shape to this shape.
	 * 
	 * @param shape
	 *            The shape to add
	 * @throws ShapeDoesNotSupportChildren
	 *             if this shape is not a composite
	 */
	public void addShape(Shape shape) {
		this.shapes.add(shape);
	}

	public List<Shape> getShapes() {
		return this.shapes;
	}

	/**
	 * @param circle
	 * @return
	 */
	public List<Shape> getShapesByType(ShapeType circle) {
		List<Shape> returnShapes = createShapesList();
		for (Shape shape :  this.shapes) {
			if ( shape.getType().equals(circle)) {
				returnShapes.add(shape);
			}
		}
		return returnShapes;
	}

	/**
	 * Return all shapes that are leafs in the tree
	 * @return
	 */
	public List<Shape> getLeafShapes() {
		List<Shape> returnLeafs = createShapesList(); 
		for ( Shape aShape: this.shapes ) {
			if (aShape.asComposite()==null) {
				returnLeafs.add(aShape);
			}
		}
		return returnLeafs;
		
	}

	

	/**
	 * Factory method for the list of children of this shape
	 * 
	 * @return
	 */
	protected List<Shape> createShapesList() {
		return new ArrayList<Shape>();
	}
}
