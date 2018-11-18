package rt.nnc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle








//
//     _   _             _             _   _
//    | \ | |           (_)           | | (_)
//    |  \| | __ ___   ___  __ _  __ _| |_ _ _ __   __ _
//    | . ` |/ _` \ \ / / |/ _` |/ _` | __| | '_ \ / _` |
//    | |\  | (_| |\ V /| | (_| | (_| | |_| | | | | (_| |
//    |_| \_|\__,_| \_/ |_|\__, |\__,_|\__|_|_| |_|\__, |
//     _          _   _     __/ |                   __/ |
//    | |        | | | |   |___/                   |___/
//    | |_ ___   | |_| |__   ___
//    | __/ _ \  | __| '_ \ / _ \
//    | || (_) | | |_| | | |  __/
//     \__\___/   \__|_| |_|\___|
//     _   _             _             _   _
//    | \ | |           (_)           | | (_)
//    |  \| | __ ___   ___  __ _  __ _| |_ _  ___  _ __
//    | . ` |/ _` \ \ / / |/ _` |/ _` | __| |/ _ \| '_ \
//    | |\  | (_| |\ V /| | (_| | (_| | |_| | (_) | | | |
//    |_| \_|\__,_| \_/ |_|\__, |\__,_|\__|_|\___/|_| |_|
//      _____               __/ |                         _
//     / ____|             |___/                         | |
//    | |     ___  _ __ ___  _ __   ___  _ __   ___ _ __ | |_
//    | |    / _ \| '_ ` _ \| '_ \ / _ \| '_ \ / _ \ '_ \| __|
//    | |___| (_) | | | | | | |_) | (_) | | | |  __/ | | | |_
//     \_____\___/|_| |_| |_| .__/ \___/|_| |_|\___|_| |_|\__|
//                          | |
//                          |_|
//










//
//     _____      _            _       _                    __
//    |  __ \    (_)          (_)     | |                  / _|
//    | |__) | __ _ _ __   ___ _ _ __ | | ___  ___    ___ | |_
//    |  ___/ '__| | '_ \ / __| | '_ \| |/ _ \/ __|  / _ \|  _|
//    | |   | |  | | | | | (__| | |_) | |  __/\__ \ | (_) | |
//    |_|   |_|  |_|_| |_|\___|_| .__/|_|\___||___/  \___/|_|
//     _   _             _      | |    _   _
//    | \ | |           (_)     |_|   | | (_)
//    |  \| | __ ___   ___  __ _  __ _| |_ _  ___  _ __
//    | . ` |/ _` \ \ / / |/ _` |/ _` | __| |/ _ \| '_ \
//    | |\  | (_| |\ V /| | (_| | (_| | |_| | (_) | | | |
//    |_| \_|\__,_| \_/ |_|\__, |\__,_|\__|_|\___/|_| |_|
//                          __/ |
//                         |___/
//










//
//
//
//
//    Apps should have a fixed starting destination.
//
//
//
//










//
//
//
//
//    An app's navigation stack is represented as a stack: last in, first out.
//
//    - Bottom of the stack is the starting destination
//    - Top of the stack is the current screen
//
//
//
//










//
//
//
//
//    Up and back are equivalent within your own task and not on the starting destination.
//
//    - Starting destination: back takes you out of the app + up doesn't exist
//    - If your activity is part of another app's task, then back exits your app
//      and up goes to starting destination, eg. sharing, handling ACTION_SEND
//    - Adventures in Navigation: https://youtu.be/ST2W1Y_Ztvk?t=163
//
//
//
//










//
//
//
//
//    Deep linking to a destination and navigating to a destination should have the
//    same back stack.
//
//    - Regardless of how a user gets to a destination, they should be able to up/back
//      to the start destination
//    - Existing back stack is removed and replaced with deep link's navigation stack
//    - Some confusion on whether they should be the "exact same" back stack:
//      Adventures in Navigation: https://youtu.be/ST2W1Y_Ztvk?t=192
//
//
//
//










//
//
//
//
//    So why use the Navigation Component?
//
//    - Better tools for more consistency
//    - Less boilerplate, less error-prone, e.g. deep linking is "first class"
//    - KTX-syntatic-sugary-goodness
//    - Visual map of navigation: maintainabilty, documentation/onboarding
//    - Easier testing in combination with FragmentScenario,
//      mocking NavControllers, etc.
//    - Not restricted to Single Activity (though it gets tons of the
//      cool new toys).
//
//
//
//










class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}










//
//
//
//
//     _______  _                    _                           _
//    |__   __|| |                  | |                         | |
//       | |   | |__    __ _  _ __  | | __  _   _   ___   _   _ | |
//       | |   | '_ \  / _` || '_ \ | |/ / | | | | / _ \ | | | || |
//       | |   | | | || (_| || | | ||   <  | |_| || (_) || |_| ||_|
//       |_|   |_| |_| \__,_||_| |_||_|\_\  \__, | \___/  \__,_|(_)
//                                           __/ |
//                                          |___/
//
//
//
//
//    Huyen Tue Dao
//    @queencodemonkey
//
//    randomlytyping.com
//
//    youtube.com/androiddialogs
//
//
//
//
