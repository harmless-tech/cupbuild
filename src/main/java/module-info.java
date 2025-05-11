// TODO: open?
module tech.harmless.cupbuild {
    requires org.jetbrains.annotations;

    // Jackson is kinda heavy, custom?
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.toml;

    exports tech.harmless.cupbuild;
}
