package at.fhv.itb3.redBlackTree;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class RBTreeTest {
	
	/**
	 * Compares the values of 2 lists
	 * @param expected is the expected value list
	 * @param actual is the actual value list
	 * @return True, if the the lists are equal. False, if the lists are not equal.
	 */
	private boolean compareListValues(List<?> expected, List<?> actual){
		boolean equals = true;
		for (int i = 0; i < expected.size(); i++) {
			if(!expected.get(i).equals(actual.get(i))){
				equals = false;
			}
		}
		
		return equals;
	}

	@Test
	public void testInsert() {
		//test insert with null root + test insert black parent
		RBTree<Integer> tree = new RBTree<>();
		
		tree.insert(1300);
		tree.insert(170);
		tree.insert(80);
		tree.insert(110);
		tree.insert(1);
		tree.insert(180);
		tree.insert(1800);

		List<Integer> l = Arrays.asList(170,80,1300,1,110,180,1800);
		List<Integer> lTree = tree.getTreeValuesLevelByLevel();
		boolean equals = compareListValues(l, lTree);
		
		List<Boolean> col = Arrays.asList(true, true, true, false, false, false, false);
		List<Boolean> colTree = tree.getTreeColoursLevelByLevel();
		boolean colEquals = compareListValues(col, colTree);
		
		assert(equals);
		assert(colEquals);
		
		//tests uncle black or nil
		//test parent left, new node left
		RBTree<Integer> tree1 = new RBTree<>();
		tree1.insert(5);
		tree1.insert(3);
		tree1.insert(1);
		
		List<Integer> l1 = Arrays.asList(3,1,5);
		List<Integer> lTree1 = tree1.getTreeValuesLevelByLevel();
		boolean equals1 = compareListValues(l1, lTree1);
		
		List<Boolean> col1 = Arrays.asList(true, false, false);
		List<Boolean> colTree1 = tree1.getTreeColoursLevelByLevel();
		boolean colEquals1 = compareListValues(col1, colTree1);
		
		assert(equals1);
		assert(colEquals1);
		
		//test parent left, new node right
		RBTree<Integer> tree2 = new RBTree<>();
		tree2.insert(7);
		tree2.insert(5);
		tree2.insert(6);
		
		List<Integer> l2 = Arrays.asList(6,5,7);
		List<Integer> lTree2 = tree2.getTreeValuesLevelByLevel();
		boolean equals2 = compareListValues(l2, lTree2);
		
		List<Boolean> col2 = Arrays.asList(true, false, false);
		List<Boolean> colTree2 = tree2.getTreeColoursLevelByLevel();
		boolean colEquals2 = compareListValues(col2, colTree2);
		
		assert(equals2);
		assert(colEquals2);
		
		//test parent right, new node left
		RBTree<Integer> tree3 = new RBTree<>();
		tree3.insert(7);
		tree3.insert(9);
		tree3.insert(8);
		
		List<Integer> l3 = Arrays.asList(8,7,9);
		List<Integer> lTree3 = tree3.getTreeValuesLevelByLevel();
		boolean equals3 = compareListValues(l3, lTree3);
		
		List<Boolean> col3 = Arrays.asList(true, false, false);
		List<Boolean> colTree3 = tree3.getTreeColoursLevelByLevel();
		boolean colEquals3 = compareListValues(col3, colTree3);
		
		assert(equals3);
		assert(colEquals3);
		
		//test parent right, new node right
		RBTree<Integer> tree4 = new RBTree<>();
		tree4.insert(7);
		tree4.insert(9);
		tree4.insert(11);
		
		List<Integer> l4 = Arrays.asList(9,7,11);
		List<Integer> lTree4 = tree4.getTreeValuesLevelByLevel();
		boolean equals4 = compareListValues(l4, lTree4);
		
		List<Boolean> col4 = Arrays.asList(true, false, false);
		List<Boolean> colTree4 = tree4.getTreeColoursLevelByLevel();
		boolean colEquals4 = compareListValues(col4, colTree4);
		
		assert(equals4);
		assert(colEquals4);
	}

	@Test
	public void testGetRBHeight() {
		RBTree<Integer> tree = new RBTree<>();
		RBTree<Integer> tree1 = new RBTree<>();
		
		tree.insert(1300);
		tree.insert(170);
		tree.insert(80);
		tree.insert(110);
		tree.insert(1);
		tree.insert(180);
		tree.insert(1800);
		
		assert(tree.getRBHeight() == 2);
		assert(tree1.getRBHeight() == 0);

	}
	
	@Test
	public void testPrintTree() {
		RBTree<Integer> tree = new RBTree<>();
		
		tree.insert(1300);
		tree.insert(170);
		tree.insert(80);
		tree.insert(110);
		tree.insert(1);
		tree.insert(6);
		tree.insert(1);
		tree.insert(180);
		tree.insert(1800);
		tree.insert(7);

		tree.printTree();

	}

}
