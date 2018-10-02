package application;

import java.util.ArrayList;
import java.util.BitSet;

public class Set {
	private static String[] universe;
	private boolean[] set;

	public static String[] getUniverse() {
		return universe;
	}
	
	public static boolean setUniverse(String input) {
		//TODO
		if (input.equals("")) {
			return false;
		}
		String [] x = input.split(",");
		ArrayList<String> temp  = new ArrayList<>();
		for (int i = 0; i < x.length; i++) {
			int j;
			for ( j = 0; j < i ; j++) {
				if (x[i].equals(x[j])) {
					break;
				}
			}
			if (j == i) {
				temp.add(x[i]);
			}
		}
		Set.universe = temp.toArray(new String[temp.size()]);
		return true;
	}

	public boolean[] getSet() {
		return set;
	}

	public boolean setSet(String input) {
		if (input.equals("")) {
			return false;
		}
		String [] x = input.split(",");
		boolean [] temp = new boolean[universe.length];
		for (int i = 0; i < x.length; i++) {
			boolean f = false;
			for (int j = 0; j < universe.length; j++) {
				if (x[i].equals(universe[j])) {
					temp[j] = true; 
					f = true;
				}
			}
			if (!f) {
				return f;
			}
		}
		set = temp;
		return true;
	}
	public boolean[] intersection(boolean[] a) {
		boolean[] ans = new boolean[a.length];
		for (int i = 0; i < a.length; i++) {
			if (a[i] && set[i]) {
				ans[i] = true;
			}
		}
		return ans;
	}

	public boolean[] union(boolean[] a, boolean[] b) {
		boolean[] ans = new boolean[a.length];
		for (int i = 0; i < a.length; i++) {
			if (a[i] || set[i]) {
				ans[i] = true;
			}
		}
		return ans;
	}

	public boolean[] comp() {
		boolean[] ans = new boolean[set.length];
		for (int i = 0; i < set.length; i++) {
			if (!set[i]) {
				ans[i] = true;
			}
		}
		return ans;
	}

	public String toString() {
		String ans = "{" ;
		for (int i = 0; i < set.length; i++) {
			if (set[i]) {
				ans += universe[i] + ", "; 
			}
		}
		if (ans.length() > 1) {		
		ans = ans.substring(0, ans.length() - 2) + "}";}
		else {
			 ans = "Ø";
		}
		return ans;
	}
}
