package com.dehaat.dehaatassignment.datalayer.rest.mock

import android.content.Context
import com.dehaat.dehaatassignment.R
import okhttp3.*
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.net.URLConnection
import javax.inject.Inject

class MockResponseInterceptor constructor(private val context: Context) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        // Get resource ID for mock response file.
        val fileName = getFilename(chain.request())
        val resourceId = getResourceId(fileName)
        if (resourceId == 0) {
            throw IOException("Could not find res/raw/$fileName")
        }

        // Get input stream and mime type for mock response file.
        val inputStream = context.resources.openRawResource(resourceId)
        var mimeType: String? = URLConnection.guessContentTypeFromStream(inputStream)
        if (mimeType == null) {
            mimeType = "application/json"
        }

        // Build and return mock response.
        return Response.Builder()
                .addHeader("content-type", mimeType)
                .body(ResponseBody.create(MediaType.parse(mimeType), toByteArray(inputStream)))
                .code(200)
                .message("Mock response from res/raw/$fileName")
                .protocol(Protocol.HTTP_2)
                .request(chain.request())
                .build()
    }

    @Throws(IOException::class)
    private fun toByteArray(inputStream: InputStream): ByteArray {
        val outStream = ByteArrayOutputStream()
        val b = ByteArray(14096)
        var n: Int = 0
        n = inputStream.read(b)
        while (n != -1) {
            outStream.write(b, 0, n)
            n = inputStream.read(b)
        }
        return outStream.toByteArray()
    }

    private fun getResourceId(fileName: String): Int {

        return context.resources.getIdentifier(fileName.replace(".json",""), "raw", context.packageName)
    }

    private fun getFilename(request: Request): String {
        val requestMethod = request.method()
        val filename = request.url().url().path
        return filename.replace("/", "").toLowerCase()
    }
}
