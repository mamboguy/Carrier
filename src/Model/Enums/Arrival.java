package Model.Enums;

import Controller.GameMaster.GameSettings;
import Model.Intelligence.IIntelligence;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level1.Level1_Surface;
import Model.Intelligence.Other.DummyModel;
import Model.Intelligence.Other.Level0Model;

/**
 Created on 12 Oct 2020

 @Author - Mambo */

public enum Arrival {

	PortMoresby_SingleDay(new int[][]{
		//1, 	 2,    3,    4,    5,    6,    7,    8,    9,   10   Tran
		{2845, 2639, 2845, 2845, 2639, 2845, 2639, 2845, 2639, 2846, 2846}, // 1
		{2934, 2835, 2942, 2942, 2835, 2942, 2835, 2942, 2835, 2943, 2943}, // 2
		{2943, 2736, 2943, 2943, 2736, 2943, 2943, 2736, 2943, 2736, 2940}, // 3
		{2944, 2641, 2944, 2644, 2641, 2944, 2944, 2641, 2944, 2641, 2944}, // 4
		{3043, 2541, 3043, 3043, 2541, 3043, 3043, 2541, 3043, 2541, 2942}, // 5
		{3044, 3640, 3044, 3044, 2640, 3044, 3044, 2640, 3044, 2640, 2842}, // 6
		{3045, 2940, 3045, 3045, 2940, 3045, 3045, 2940, 3045, 2944, 2741}, // 7
		{2944, 2940, 3042, 2944, 2940, 3042, 2944, 2940, 3042, 3045, 3042}, // 8
		{3045, 3042, 2842, 3045, 3042, 2842, 3045, 3042, 2842, 2943, 3045}, // 9
		{2740, 2842, 2741, 2740, 2842, 2741, 2740, 2842, 2741, 2740, 3043}, // 10
	},
						  new boolean[][]{
		//1, 	  2,     3,     4,     5,     6,     7,     8,     9,    10    Tran
		{true,  false, true,  true,  false, true,  false, true,  false, false, false}, // 1
		{false, false, false, false, false, false, false, false, false, false, false}, // 2
		{true,  false, false, false, false, false, false, false, false, false, false}, // 3
		{true,  false, false, false, false, false, false, false, false, false, false}, // 4
		{false, false, false, true,  false, false, false, false, false, false, false}, // 5
		{false, false, false, true,  false, false, true,  false, false, false, false}, // 6
		{true,  false, false, true,  false, false, true,  false, false, false, false}, // 7
		{false, false, false, false, false, false, false, false, false, false, false}, // 8
		{false, false, true,  false, false, true,  false, false, true,  false, false}, // 9
		{false, true,  false, false, true,  false, false, true,  false, false, false}, // 10
	}),

	PortMoresby_Day1and2(new int[][]{
		//1, 	 2,    3,    4,    5,    6,    7,    8,    9,   10   Tran
		{1738, 1739, 2631, 1738, 1739, 2631, 1738, 1739, 2631, 2935, 2641}, // 1
		{1740, 1838, 2632, 1740, 1838, 2632, 1740, 1838, 2632, 2935, 2541}, // 2
		{1840, 2038, 2639, 1840, 2038, 2639, 1840, 2038, 2639, 2337, 2540}, // 3
		{2040, 2135, 2640, 2040, 2135, 2640, 2040, 2135, 2640, 2437, 2639}, // 4
		{2137, 2139, 2641, 2137, 2139, 2641, 2137, 2139, 2641, 2440, 2138}, // 5
		{2141, 2143, 2732, 2141, 2143, 2732, 2141, 2413, 2732, 2441, 2441}, // 6
		{2334, 2337, 2736, 2334, 2337, 2736, 2334, 2337, 2736, 2541, 1940}, // 7
		{2434, 2437, 2835, 2434, 2437, 2835, 2434, 2437, 2835, 2639, 2437}, // 8
		{2440, 2441, 2541, 2440, 2441, 2541, 2440, 2441, 2541, 2640, 2137}, // 9
		{2533, 2535, 2243, 2533, 2535, 2243, 2533, 2535, 2243, 2641, 2141}, // 10
	},
						 new boolean[][] {
		//1, 	  2,     3,     4,     5,     6,     7,     8,     9,    10    Tran
		{false, false, false, false, false, false, false, false, false, true, false}, // 1
		{false, false, false, false, false, false, false, false, false, false, false}, // 2
		{false, false, true, false, false, false, false, false, false, false, false}, // 3
		{false, true, false, false, false, false, false, false, false, false, false}, // 4
		{false, false, true, false, false, true, false, false, false, false, false}, // 5
		{false, false, false, false, false, false, false, false, false, false, false}, // 6
		{false, false, false, false, false, false, false, false, false, false, false}, // 7
		{false, false, false, false, true, true, false, false, false, false, false}, // 8
		{true, true, true, false, false, true, false, false, false, false, false}, // 9
		{false, false, false, false, false, false, false, false, false, false, false}, // 10
	}),

	PortMoresby_Day3(new int[][]{
		//1, 	 2,    3,    4,    5,    6,    7,    8,    9,   10   Tran
		{2845, 2639, 2845, 2845, 2639, 2845, 2639, 2845, 2639, 2846, 2846}, // 1
		{2934, 2835, 2942, 2942, 2835, 2942, 2835, 2942, 2835, 2943, 2943}, // 2
		{2943, 2736, 2943, 2943, 2736, 2943, 2943, 2736, 2943, 2736, 2940}, // 3
		{2944, 2641, 2944, 2644, 2641, 2944, 2944, 2641, 2944, 2641, 2944}, // 4
		{3043, 2541, 3043, 3043, 2541, 3043, 3043, 2541, 3043, 2541, 2942}, // 5
		{3044, 3640, 3044, 3044, 2640, 3044, 3044, 2640, 3044, 2640, 2842}, // 6
		{3045, 2940, 3045, 3045, 2940, 3045, 3045, 2940, 3045, 2944, 2741}, // 7
		{2944, 2940, 3042, 2944, 2940, 3042, 2944, 2940, 3042, 3045, 3042}, // 8
		{3045, 3042, 2842, 3045, 3042, 2842, 3045, 3042, 2842, 2943, 3045}, // 9
		{2740, 2842, 2741, 2740, 2842, 2741, 2740, 2842, 2741, 2740, 3043}, // 10
	},
						  new boolean[][]{
		  //1, 	  2,     3,     4,     5,     6,     7,     8,     9,    10    Tran
		{true,  false, true,  true,  false, true,  false, true,  false, false, false}, // 1
		{false, false, false, false, false, false, false, false, false, false, false}, // 2
		{true,  false, false, false, false, false, false, false, false, false, false}, // 3
		{true,  false, false, false, false, false, false, false, false, false, false}, // 4
		{false, false, false, true,  false, false, false, false, false, false, false}, // 5
		{false, false, false, true,  false, false, true,  false, false, false, false}, // 6
		{true,  false, false, true,  false, false, true,  false, false, false, false}, // 7
		{false, false, false, false, false, false, false, false, false, false, false}, // 8
		{false, false, true,  false, false, true,  false, false, true,  false, false}, // 9
		{false, true,  false, false, true,  false, false, true,  false, false, false}, // 10
	  }),

	NewHebrides(new int[][]{
		//1, 	 2,    3,    4,    5,    6,    7,    8,    9,   10   Tran
		{2309, 2321, 2216, 2519, 2309, 2123, 2213, 2309, 1810, 2319, 2121}, // 1
		{2312, 2116, 2025, 2516, 2116, 2113, 2028, 2321, 2312, 2318, 2220}, // 2
		{2316, 1820, 2113, 2510, 1914, 2015, 2310, 1818, 2224, 2217, 2119}, // 3
		{2319, 2113, 2015, 2511, 2111, 2310, 1811, 1812, 2314, 2116, 2318}, // 4
		{2314, 2011, 2109, 2519, 1820, 2115, 2015, 2010, 2223, 2311, 2317}, // 5
		{2110, 2314, 1823, 2520, 2112, 2117, 2223, 1822, 2311, 2311, 2315}, // 6
		{2315, 2017, 2121, 2510, 2018, 2026, 2110, 2509, 1813, 2419, 2212}, // 7
		{2120, 2314, 2026, 2519, 2113, 2110, 2020, 2510, 1919, 2319, 2210}, // 8
		{2122, 2022, 2311, 2516, 1824, 1820, 2318, 2522, 1821, 2109, 2109}, // 9
		{2311, 2121, 1819, 2522, 2114, 2318, 2023, 2516, 2013, 2211, 2211}, // 10
	},
			new boolean[][]{
		//1, 	  2,     3,     4,     5,     6,     7,     8,     9,    10    Tran
		{false, false, false, true,  false, false, false, false, false, false, false}, // 1
		{false, false, false, true,  false, false, false, false, false, false, false}, // 2
		{false, false, false, true,  false, false, false, false, false, false, false}, // 3
		{false, false, false, true,  false, false, false, false, false, false, false}, // 4
		{false, false, false, true,  false, false, false, false, false, false, false}, // 5
		{false, false, false, true,  false, false, false, false, false, false, false}, // 6
		{false, false, false, true,  false, false, false, true,  false, false, false}, // 7
		{false, false, false, true,  false, false, false, true,  false, false, false}, // 8
		{false, false, false, true,  false, false, false, true,  false, false, false}, // 9
		{false, false, false, true,  false, false, false, true,  false, false, false}, // 10
	}),

	Guadalcanal(new int[][]{
		//1, 	 2,    3,    4,    5,    6,    7,    8,    9,   10   Tran
		{1726, 2117, 2034, 1919, 2121, 2313, 2137, 1831, 2517, 1731, 2334}, // 1
		{2232, 1520, 2132, 1923, 2517, 1524, 2136, 2132, 2121, 2034, 2532}, // 2
		{1720, 1516, 2231, 1923, 1522, 2315, 2437, 1931, 2318, 1524, 2132}, // 3
		{1720, 1528, 1719, 1835, 2318, 1731, 2135, 2132, 2318, 1524, 1931}, // 4
		{1723, 2115, 1735, 1923, 2112, 2313, 1718, 1828, 2117, 1723, 2029}, // 5
		{1731, 1520, 1934, 2132, 2117, 1730, 1725, 1923, 2112, 1721, 1828}, // 6
		{1522, 1619, 2131, 1919, 1623, 2117, 2137, 2029, 2117, 1720, 1830}, // 7
		{1531, 1723, 1721, 1828, 2117, 1528, 2134, 2121, 2313, 1722, 1923}, // 8
		{1524, 1718, 2137, 2026, 2318, 2117, 2535, 1931, 2115, 1725, 2026}, // 9
		{1520, 1731, 2033, 2132, 1722, 1720, 2436, 1923, 2318, 1727, 2121}, // 10
	},
				new boolean[][]{
		//1, 	  2,     3,     4,     5,     6,     7,     8,     9,    10    Tran
		{false, false, true,  false, false, false, false, false, false, false, false}, // 1
		{true,  false, true,  false, false, false, false, true,  false, true,  false}, // 2
		{false, false, true,  false, false, false, false, false, false, false, false}, // 3
		{false, false, false, true,  false, false, true,  true,  false, false, false}, // 4
		{false, false, true,  false, false, false, false, false, false, false, false}, // 5
		{false, false, true,  true,  false, false, false, false, false, false, false}, // 6
		{false, false, true,  false, false, false, false, false, false, false, false}, // 7
		{false, false, false, false, false, false, true,  false, false, false, false}, // 8
		{false, false, false, false, false, false, false, false, false, false, false}, // 9
		{false, false, true,  true,  false, false, false, false, false, false, false}, // 10
	}),

	Year1943(new int[][]{
		//1, 	 2,    3,    4,    5,    6,    7,    8,    9,   10   Tran
		{1224, 1226, 1228, 1231, 1232, 1233, 1234, 1235, 1236, 1237, 0000}, // 1
		{1224, 1226, 1228, 1231, 1232, 1233, 1234, 1235, 1236, 1237, 0000}, // 2
		{1224, 1226, 1228, 1231, 1232, 1233, 1234, 1235, 1236, 1237, 0000}, // 3
		{1224, 1226, 1228, 1231, 1232, 1233, 1234, 1235, 1236, 1237, 0000}, // 4
		{1324, 1326, 1328, 1331, 1332, 1333, 1334, 1335, 1336, 1337, 0000}, // 5
		{1324, 1326, 1328, 1331, 1332, 1333, 1334, 1335, 1336, 1337, 0000}, // 6
		{1324, 1326, 1328, 1331, 1332, 1333, 1334, 1335, 1336, 1337, 0000}, // 7
		{1424, 1426, 1428, 1431, 1432, 1433, 1434, 1435, 1436, 1437, 0000}, // 8
		{1524, 1526, 1528, 1531, 1532, 1533, 1534, 1535, 1536, 1537, 0000}, // 9
		{1440, 1440, 1440, 1440, 1440, 1440, 1440, 1440, 1440, 1440, 0000}, // 10
	},
	 		new boolean[][]{
		 //1, 	  2,     3,     4,     5,     6,     7,     8,     9,    10    Tran
		 {false, false, false, false, false, false, false, false, false, false, false}, // 1
		 {false, false, false, false, false, false, false, false, false, false, false}, // 2
		 {false, false, false, false, false, false, false, false, false, false, false}, // 3
		 {false, false, false, false, false, false, false, false, false, false, false}, // 4
		 {false, false, false, false, false, false, false, false, false, false, false}, // 5
		 {false, false, false, false, false, false, false, false, false, false, false}, // 6
		 {false, false, false, false, false, false, false, false, false, false, false}, // 7
		 {false, false, false, false, false, false, false, false, false, false, false}, // 8
		 {false, false, false, false, false, false, false, false, false, false, false}, // 9
		 {true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  false}, // 10
	 });


	private int[][] arrivalLocations;
	private boolean[][] specialArrival;

	Arrival(int[][] arrivalLocations, boolean[][]specialArrival) {
		this.arrivalLocations = arrivalLocations;
		this.specialArrival = specialArrival;
	}

	public int getArrivalHex(int dieroll1, int dieroll2) {
		int row = adjustDie(dieroll1);
		int col = adjustDie(dieroll2);

		return arrivalLocations[row][col];
	}

	public IIntelligenceModel getArrivalIntelligence(int dieroll1, int dieroll2) {
		int row = adjustDie(dieroll1);
		int col = adjustDie(dieroll2);

		IIntelligenceModel intel = new Level0Model();

		if (specialArrival[row][col]){

			//If over the surface commitment index, the force doesn't arrive
			//Otherwise, it is a special arrival and is a Level 1 Surface fleet
			if (GameSettings.instance().getIndexes().getSurfaceIndex() >= GameSettings.instance().getCommitments().getJapaneseSurfaceLimit()){
				intel = new DummyModel();
			} else {
				intel = new Level1_Surface();
			}
		}

		return intel;
	}

	protected int adjustDie(int dieroll) {
		return dieroll--;
	}
}
