package jp.co.underscore.httpsdispatch

import android.os._
import android.support.v4.app._
import com.ning.http.client.AsyncHttpClientConfig
import com.ning.http.client.providers.netty.NettyAsyncHttpProvider
import dispatch._

import scala.concurrent.ExecutionContext.Implicits.global

class MainActivity extends FragmentActivity with TypedViewHolder {

  new NettyAsyncHttpProvider(new AsyncHttpClientConfig.Builder().build())

  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val f = Future {
      Http(url("https://google.com/"))
    }.flatten
    f onFailure { case throwable => throwable.printStackTrace()}
  }
}
