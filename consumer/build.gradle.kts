import com.javiersc.repro.plugin.ReproExtension
import com.javiersc.repro.plugin.ReproNestedExtension

plugins {
    id("com.javiersc.repro.plugin") version "0.1.0"
}

// those both works
the<ReproExtension>()
the<ReproNestedExtension>()

// this works
//repro {
//
//}

// this doesn't work
//repro {
//    reproNested {
//
//    }
//}
