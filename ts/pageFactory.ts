---
---
/// <reference path="page.ts" />
{% for p in site.data.pages %}
    /// <reference path="pages/{{ p.name }}.ts" />
{% endfor %}

namespace org.usd232.robotics.management {
    {% for p in site.data.pages %}
        import {{ p.controllerClass }} = org.usd232.robotics.management.pages.{{ p.controllerClass }};
    {% endfor %}

    export class PageFactory {
        public static construct(): AbstractPage[] {
            return [
                {% for p in site.data.pages %}
                    new {{ p.controllerClass }}("{{ p.name }}"),
                {% endfor %}
            ];
        }
    }
}
