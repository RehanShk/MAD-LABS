import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri

class JokeContentProvider : ContentProvider() {

    companion object {
        const val AUTHORITY = "com.example.jokes.provider"
        const val PATH_JOKES = "jokes"
        const val CONTENT_URI = "content://$AUTHORITY/$PATH_JOKES"
        const val JOKE_ID = "id"
        const val JOKE_TEXT = "text"
        const val MIME_TYPE_DIR = "vnd.android.cursor.dir/vnd.$AUTHORITY.$PATH_JOKES"
        const val MIME_TYPE_ITEM = "vnd.android.cursor.item/vnd.$AUTHORITY.$PATH_JOKES"
        const val CODE_JOKES_DIR = 1
        const val CODE_JOKE_ITEM = 2
    }

    private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
        addURI(AUTHORITY, PATH_JOKES, CODE_JOKES_DIR)
        addURI(AUTHORITY, "$PATH_JOKES/#", CODE_JOKE_ITEM)
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun getType(uri: Uri): String? {
        return when (uriMatcher.match(uri)) {
            CODE_JOKES_DIR -> MIME_TYPE_DIR
            CODE_JOKE_ITEM -> MIME_TYPE_ITEM
            else -> throw IllegalArgumentException("Unknown URI: $uri")
        }
    }

    override fun query(
        uri: Uri, projection: Array<out String>?, selection: String?,
        selectionArgs: Array<out String>?, sortOrder: String?
    ): Cursor? {
        val cursor = MatrixCursor(arrayOf(JOKE_ID, JOKE_TEXT))
        cursor.addRow(arrayOf(1, "Why did the scarecrow win an award? Because he was outstanding in his field!"))
        return cursor
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        return 0
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        return 0
    }
}
