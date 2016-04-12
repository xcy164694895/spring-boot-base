package cn.weeego.test;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;
import com.gecpp.fm.IFuzzySearch;
import com.gecpp.fm.QueryResult;

public class Testhession {
	public static void main(String[] args) {

		HessianProxyFactory factory = new HessianProxyFactory();
		IFuzzySearch api;
		try {
			api = (IFuzzySearch) factory.create(IFuzzySearch.class,
					"http://113.106.92.172/fm/portal");

			String[] parts = new String[2];
			parts[0] = ("VJ0805Y103JXXPW1BC_____10");
			parts[1] = ("15000018_____10");
			QueryResult queryResult = api.getProductByMultipleSearch(parts);

			System.out.println(queryResult.getPidListGroupMfs1());

			System.out.println(queryResult.getPidListGroupMfs2());

			System.out.println(queryResult.getPidListGroupMfs3());

		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

	}
}
