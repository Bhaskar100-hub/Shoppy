package wary.bhaskar.shoppy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {
    var productList = ArrayList<Product>()
    val product1 = Product(R.drawable.product_one, "Cotton Dress", "$10")
    val product2 = Product(R.drawable.product_two, "Denim Top", "$11")
    val product3 = Product(R.drawable.product_three, "Denim Shorts", "$8")
    val product4 = Product(R.drawable.product_four, "Cotton Top", "$11")
    val product5 = Product(R.drawable.product_five, "Flare Top", "$9")
    val product6 = Product(R.drawable.product_six, "Denim Shorts", "$10")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(context,
        2,
        GridLayoutManager.VERTICAL,
        false)

        productList.add(product1)
        productList.add(product2)
        productList.add(product3)
        productList.add(product4)
        productList.add(product5)
        productList.add(product6)

        val adapter = ProductAdapter(productList)
        recyclerView.adapter = adapter




        /*      view.findViewById<Button>(R.id.btn_log_out).setOnClickListener {
            Firebase.auth.signOut()
            var  navLogin = activity as FragmentNavigation
            navLogin.navigateFrag(LoginFragment(), addToStack = false)
        }*/
        return view
    }
}