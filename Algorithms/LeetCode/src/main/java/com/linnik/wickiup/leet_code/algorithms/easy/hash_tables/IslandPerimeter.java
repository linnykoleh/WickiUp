package com.linnik.wickiup.leet_code.algorithms.easy.hash_tables;

/**
 * @author LinnykOleh
 */
public class IslandPerimeter {

	/**
	 *
	 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
	 * Grid cells are connected horizontally/vertically (not diagonally).
	 * The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
	 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
	 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
	 *
	 * Example:
     *
	 *	   [[0,1,0,0],
	 *		[1,1,1,0],
	 *		[0,1,0,0],
	 *		[1,1,0,0]]
	 *
	 * Answer:
	 * 		16
	 *
	 * Explanation:
	 * 		The perimeter is the 16 yellow stripes in the image below:
	 *
	 * 		-------------
	 * 		|  |##|  |  |
	 * 		-------------
	 * 		|##|##|##|  |
	 * 		-------------
	 * 		|  |##|  |  |
	 * 		-------------
	 * 		|##|##|  |  |
	 * 		-------------
	 *
	 * @param grid two-dimensional integer grid
	 * @return     the perimeter of the island
	 */
	public int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

		int perimeter = 0;

		for(int outer = 0; outer < grid.length; outer++){
			for(int inner = 0; inner < grid[outer].length; inner++){
				if(grid[outer][inner] == 1){
					if((inner == 0) || (inner - 1 >= 0 && grid[outer][inner - 1] == 0)) perimeter++;
					if((inner == grid[outer].length - 1) || (inner + 1 != grid[outer].length && grid[outer][inner + 1] == 0)) perimeter++;
					if((outer - 1 < 0) || (outer - 1 >= 0 && grid[outer - 1][inner] == 0)) perimeter++;
					if((outer + 1 >= grid.length) || (outer + 1 != grid.length && grid[outer + 1][inner] == 0)) perimeter++;
				}
			}
		}
		return perimeter;
	}

}
