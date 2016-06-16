import java.util.Timer;
import java.util.TimerTask;

import com.formation.entity.Product;
import com.formation.facade.VenteFacade;
import com.formation.service.ProductService;
import com.formation.test.JeuxDeTest;

public class ProductDaoTest {

	public static void main(String[] args) {

		TimerTask task = new TimerTask() {
			JeuxDeTest t = new JeuxDeTest();
			ProductService productService = VenteFacade.getInstance().getProductService();

			@Override
			public void run() {

				Product p = t.getProduct();
				//System.out.println(p);

				productService.createProduct(p);

			}
		};

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, 1000);
	}
}
