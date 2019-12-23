# Stages

Stages can be used to divide your application into multiple sections, where each section can have its own configuration. Each application automatically has one "default" stage, which captures all requests not matching with custom stages.

This is how the default stage configuration looks like:

```trig
elmo:DefaultStage a elmo:Stage;
  elmo:basePath "/";
  elmo:layout elmo:DefaultLayout;
.
```

You can add your own stages to add sections for your application. Example:

```trig
config:DbeerpediaStage a elmo:Stage;
  elmo:basePath "/dbeerpedia";
  elmo:layout elmo:DefaultLayout;
  dc:title "DBeerPedia";
  xsd:language: "nl";
.
```

Macro | Behavior
--- | ---
`elmo:basePath` | The base path for all endpoints served on this stage. A base path must always start with a forward slash.
`dc:title` | @TODO
`xsd:language` | @TODO

Stages can be used to serve endpoints for multiple domains. However, you will need a reverse proxy (e.g. a webserver like Apache or Nginx) to perform the domain matching and routing of each domain to an internal base path.

@TODO More explanation, add Apache & Nginx configuration examples.

# Layouts

Layouts are templates which are used to render the HTML representation of resources.
Each application automatically hass one "default" layout, providing a simple base layout.

This is how the default layout configuration looks like:

```trig
elmo:DefaultLayout a elmo:Layout;
  elmo:template ```
    <!doctype html>
    <html lang="${lang}">
      <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <base href="https://www.w3schools.com/images/">
        <title>${title}</title>
        <@styles/>
      </head>
      <body>
        <div class="container">
          <header>
            <div class="brand">
              <img src="assets/logo.png">
            </div>
          </header>
          <@content/>
        </div>
        <@scripts/>
      </body>
    </html>
  ```;
.
```

There is a set of variables and [macros](https://freemarker.apache.org/docs/ref_directive_macro.html) which can be used to render dynamic values within the template. For all output, escaping of reserved HTML characters is automatically handled.

Variable | Behavior
--- | ---
`lang` | @TODO
`title` | @TODO

Macro | Behavior
--- | ---
`styles` | @TODO
`content` | @TODO
`scripts` | @TODO

# Endpoints
