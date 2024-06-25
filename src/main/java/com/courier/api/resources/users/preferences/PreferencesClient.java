/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.courier.api.resources.users.preferences;

import com.courier.api.core.ClientOptions;
import com.courier.api.core.CourierApiApiError;
import com.courier.api.core.CourierApiError;
import com.courier.api.core.MediaTypes;
import com.courier.api.core.ObjectMappers;
import com.courier.api.core.RequestOptions;
import com.courier.api.resources.commons.errors.CourierApiBadRequestError;
import com.courier.api.resources.commons.errors.CourierApiNotFoundError;
import com.courier.api.resources.commons.types.BadRequest;
import com.courier.api.resources.commons.types.NotFound;
import com.courier.api.resources.users.preferences.requests.UserPreferencesUpdateParams;
import com.courier.api.resources.users.preferences.types.UserPreferencesGetResponse;
import com.courier.api.resources.users.preferences.types.UserPreferencesListResponse;
import com.courier.api.resources.users.preferences.types.UserPreferencesUpdateResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class PreferencesClient {
    protected final ClientOptions clientOptions;

    public PreferencesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Fetch all user preferences.
     */
    public UserPreferencesListResponse list(String userId) {
        return list(userId, null);
    }

    /**
     * Fetch all user preferences.
     */
    public UserPreferencesListResponse list(String userId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("users")
                .addPathSegment(userId)
                .addPathSegments("preferences")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), UserPreferencesListResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                if (response.code() == 400) {
                    throw new CourierApiBadRequestError(
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, BadRequest.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new CourierApiApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new CourierApiError("Network error executing HTTP request", e);
        }
    }

    /**
     * Fetch user preferences for a specific subscription topic.
     */
    public UserPreferencesGetResponse get(String userId, String topicId) {
        return get(userId, topicId, null);
    }

    /**
     * Fetch user preferences for a specific subscription topic.
     */
    public UserPreferencesGetResponse get(String userId, String topicId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("users")
                .addPathSegment(userId)
                .addPathSegments("preferences")
                .addPathSegment(topicId)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), UserPreferencesGetResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                if (response.code() == 404) {
                    throw new CourierApiNotFoundError(
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, NotFound.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new CourierApiApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new CourierApiError("Network error executing HTTP request", e);
        }
    }

    /**
     * Update or Create user preferences for a specific subscription topic.
     */
    public UserPreferencesUpdateResponse update(String userId, String topicId, UserPreferencesUpdateParams request) {
        return update(userId, topicId, request, null);
    }

    /**
     * Update or Create user preferences for a specific subscription topic.
     */
    public UserPreferencesUpdateResponse update(
            String userId, String topicId, UserPreferencesUpdateParams request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("users")
                .addPathSegment(userId)
                .addPathSegments("preferences")
                .addPathSegment(topicId)
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new CourierApiError("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("PUT", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), UserPreferencesUpdateResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                if (response.code() == 400) {
                    throw new CourierApiBadRequestError(
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, BadRequest.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new CourierApiApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new CourierApiError("Network error executing HTTP request", e);
        }
    }
}
