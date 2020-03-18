package skripa.ru.fuunymoments.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

abstract class BasePageAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    abstract val pages: ArrayList<PageFragment>

    override fun getCount(): Int = pages.size

    override fun getItem(position: Int): Fragment = pages[position].fragment

    override fun getPageTitle(position: Int): CharSequence? = pages[position].title

}

data class PageFragment(
    val title: String = "",
    val fragment: Fragment
)

///////////////
//example using
///////////////

//*class FAQPagerAdapter(fm: FragmentManager, val context: Context): BasePageAdapter(fm) {
//
//    override val pages: ArrayList<PageFragment> = arrayListOf(
//        PageFragment(context.getString(R.string.screen_faq_tab_top_questions),  TopQuestionFragment()),
//        PageFragment(context.getString(R.string.screen_faq_tab_starter_kit),  StarterKitFragment())
//    )
//}*/