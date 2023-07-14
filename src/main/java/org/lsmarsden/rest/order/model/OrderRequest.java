package org.lsmarsden.rest.order.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderRequest(
        @JsonProperty("milk")
        int milkQuantity,
        @JsonProperty("sugar")
        int sugarQuantity) {
}
