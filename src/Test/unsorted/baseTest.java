package Test.unsorted;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class baseTest {

	@Test
	public void test() {

		ArrayList<ArrayList<String>> affinityClusters = new ArrayList<>();
		Scanner scan = new Scanner(System.in);

		/* The defined affinity threshold */
		float affinity_threshold = scan.nextFloat();

		/* The number of relationships */
		int relationshipCount = scan.nextInt();

		for (int i = 0; i < relationshipCount; i++) {
			String firstItem = scan.next();
			String secondItem = scan.next();
			float inputThreshold = scan.nextFloat();

			if (inputThreshold > affinity_threshold) {
				boolean used = false;
				for (ArrayList<String> cluster : affinityClusters) {
					if (cluster.contains(firstItem)) {
						if (!cluster.contains(secondItem)) {
							cluster.add(secondItem);
						}
						used = true;
					}
				}
				if (!used) {
					ArrayList<String> cluster = new ArrayList<>();
					cluster.add(firstItem);
					cluster.add(secondItem);
					affinityClusters.add(cluster);
				}
			} else {
				ArrayList<String> cluster = new ArrayList<>();
				cluster.add(firstItem);
				affinityClusters.add(cluster);
			}
		}

		ArrayList<Integer> selectedCluster = new ArrayList<>();

		/* Sort lists and count members */
		int max = 0;
		for (int i = 0; i < affinityClusters.size(); i++) {
			Collections.sort(affinityClusters.get(i));
			if (affinityClusters.get(i).size() > max) {
				max = affinityClusters.get(i).size();
				selectedCluster.clear();
				selectedCluster.add(i);
			} else if (affinityClusters.get(i).size() == max) {
				selectedCluster.add(i);
			}
		}

		/* Get the first element of all selected affinity clusters */
		ArrayList<String> clusterStart = new ArrayList<>();
		for (int selected : selectedCluster) {
			clusterStart.add(affinityClusters.get(selected).get(0));
		}

		/* Sort the first entries */
		Collections.sort(clusterStart);

		for (int selected : selectedCluster) {
			if (clusterStart.get(0).equals(affinityClusters.get(selected).get(0))) {
				System.out.println(affinityClusters.get(selected).get(0));
				break;
			}
		}
		scan.close();
	}

}
