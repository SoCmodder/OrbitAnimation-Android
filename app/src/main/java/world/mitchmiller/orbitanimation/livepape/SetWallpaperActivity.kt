package world.mitchmiller.orbitanimation.livepape

import android.app.WallpaperManager
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import world.mitchmiller.orbitanimation.R
import world.mitchmiller.orbitanimation.livepape.service.DerpOrbitWallpaperService

class SetWallpaperActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_wallpaper)
    }

    public fun onClick(view: View) {
        var intent = Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER)
        intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
            ComponentName(this@SetWallpaperActivity, DerpOrbitWallpaperService::class.java))
        startActivity(intent)
    }
}