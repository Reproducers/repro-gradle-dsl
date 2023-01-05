import com.javiersc.repro.plugin.ReproExtension
import com.javiersc.repro.plugin.ReproNestedExtension
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the

fun Project.repro(action: Action<ReproExtension>) {
    action.execute(the())

    println("After configuration `someProperty`: ${the<ReproNestedExtension>().someProperty.get()}")
}
