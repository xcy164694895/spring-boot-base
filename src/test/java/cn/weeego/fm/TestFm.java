package cn.weeego.fm;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;
import com.gecpp.fm.IFuzzySearch;
import com.gecpp.fm.QueryResult;

public class TestFm {
	public static void main(String[] args) {

		HessianProxyFactory factory = new HessianProxyFactory();
		IFuzzySearch api;
		try {
			api = (IFuzzySearch) factory.create(IFuzzySearch.class,
					"http://113.106.92.172/fm/portal");

			String[] parts = new String[18];
			parts[0] = ("D55342K07B499DMSV");
			parts[1] = ("D45VH10");
			parts[2] = ("1421633");
			parts[3] = ("06035C471JAT2A");
			parts[4] = ("2774017");
			parts[5] = ("UC2846NG4");
			parts[6] = ("HD74LS14P");
			parts[7] = ("X5168PZ-2.7");
			parts[8] = ("ATMEGA32L-8AC$09099");
			parts[9] = ("T353A334K035AS7301");
			parts[10] = ("TEP 100-4818.");
			parts[11] = ("TFM-106-02-S-D-P");
			parts[12] = ("TW-15-11-F-D-195-090");
			parts[13] = ("1761602-3");
			parts[14] = ("TPSC226K020R0150");
			parts[15] = ("39523-2418");
			parts[16] = ("ZZY-RO-12D28-42P");
			parts[17] = ("TSW-224-20-F-D");
			QueryResult queryResult = api.getProductByMultipleSearch(parts);
			System.out.println(queryResult.getPidListGroupMfs1());
			System.out.println(queryResult.getPidListGroupMfs2());
			System.out.println(queryResult.getPidListGroupMfs3());
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

	}
}
