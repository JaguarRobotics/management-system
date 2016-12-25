---
---

namespace org.usd232.robotics.management {
    export class Providers {
        public static getProviderNames(): string[] {
            return [
                {% for p in site.data.providers %}
                    "{{ p.name }}",
                {% endfor %}
            ];
        }
    }
}
