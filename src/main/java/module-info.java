// TODO: open?
@org.jspecify.annotations.NullMarked
module tech.harmless.cupbuild {
    requires org.jspecify;
    requires org.tinylog.api;
    requires org.tinylog.impl;

    // Jackson is kinda heavy, custom?
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.toml;

    // Java Stdlib
    requires java.base;
    requires java.compiler;

    exports tech.harmless.cupbuild;
}
