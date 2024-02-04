/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.courier.api.resources.lists;

import com.courier.api.core.ApiError;
import com.courier.api.core.ClientOptions;
import com.courier.api.core.IdempotentRequestOptions;
import com.courier.api.core.MediaTypes;
import com.courier.api.core.ObjectMappers;
import com.courier.api.core.RequestOptions;
import com.courier.api.resources.lists.requests.GetAllListsRequest;
import com.courier.api.resources.lists.requests.GetListRequest;
import com.courier.api.resources.lists.requests.GetSubscriptionForListRequest;
import com.courier.api.resources.lists.requests.SubscribeUserToListRequest;
import com.courier.api.resources.lists.types.List;
import com.courier.api.resources.lists.types.ListGetAllResponse;
import com.courier.api.resources.lists.types.ListGetSubscriptionsResponse;
import com.courier.api.resources.lists.types.ListPutParams;
import com.courier.api.resources.lists.types.PutSubscriptionsRecipient;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ListsClient {
    protected final ClientOptions clientOptions;

    public ListsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns all of the lists, with the ability to filter based on a pattern.
     */
    public ListGetAllResponse list() {
        return list(GetAllListsRequest.builder().build());
    }

    /**
     * Returns all of the lists, with the ability to filter based on a pattern.
     */
    public ListGetAllResponse list(GetAllListsRequest request) {
        return list(request, null);
    }

    /**
     * Returns all of the lists, with the ability to filter based on a pattern.
     */
    public ListGetAllResponse list(GetAllListsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lists");
        if (request.getCursor().isPresent()) {
            httpUrl.addQueryParameter("cursor", request.getCursor().get());
        }
        if (request.getPattern().isPresent()) {
            httpUrl.addQueryParameter("pattern", request.getPattern().get());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), ListGetAllResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a list based on the list ID provided.
     */
    public List get(String listId) {
        return get(listId, GetListRequest.builder().build());
    }

    /**
     * Returns a list based on the list ID provided.
     */
    public List get(String listId, GetListRequest request) {
        return get(listId, request, null);
    }

    /**
     * Returns a list based on the list ID provided.
     */
    public List get(String listId, GetListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lists")
                .addPathSegment(listId);
        if (request.getCursor().isPresent()) {
            httpUrl.addQueryParameter("cursor", request.getCursor().get());
        }
        if (request.getPattern().isPresent()) {
            httpUrl.addQueryParameter("pattern", request.getPattern().get());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), List.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Create or replace an existing list with the supplied values.
     */
    public List update(String listId, ListPutParams request) {
        return update(listId, request, null);
    }

    /**
     * Create or replace an existing list with the supplied values.
     */
    public List update(String listId, ListPutParams request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lists")
                .addPathSegment(listId)
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("PUT", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), List.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Delete a list by list ID.
     */
    public void delete(String listId) {
        delete(listId, null);
    }

    /**
     * Delete a list by list ID.
     */
    public void delete(String listId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lists")
                .addPathSegment(listId)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Restore a previously deleted list.
     */
    public void restore(String listId) {
        restore(listId, null);
    }

    /**
     * Restore a previously deleted list.
     */
    public void restore(String listId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lists")
                .addPathSegment(listId)
                .addPathSegments("restore")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("PUT", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get the list's subscriptions.
     */
    public ListGetSubscriptionsResponse getSubscribers(String listId) {
        return getSubscribers(listId, GetSubscriptionForListRequest.builder().build());
    }

    /**
     * Get the list's subscriptions.
     */
    public ListGetSubscriptionsResponse getSubscribers(String listId, GetSubscriptionForListRequest request) {
        return getSubscribers(listId, request, null);
    }

    /**
     * Get the list's subscriptions.
     */
    public ListGetSubscriptionsResponse getSubscribers(
            String listId, GetSubscriptionForListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lists")
                .addPathSegment(listId)
                .addPathSegments("subscriptions");
        if (request.getCursor().isPresent()) {
            httpUrl.addQueryParameter("cursor", request.getCursor().get());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        response.body().string(), ListGetSubscriptionsResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Subscribes the users to the list, overwriting existing subscriptions. If the list does not exist, it will be automatically created.
     */
    public void updateSubscribers(String listId, java.util.List<PutSubscriptionsRecipient> request) {
        updateSubscribers(listId, request, null);
    }

    /**
     * Subscribes the users to the list, overwriting existing subscriptions. If the list does not exist, it will be automatically created.
     */
    public void updateSubscribers(
            String listId, java.util.List<PutSubscriptionsRecipient> request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lists")
                .addPathSegment(listId)
                .addPathSegments("subscriptions")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("PUT", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Subscribes additional users to the list, without modifying existing subscriptions. If the list does not exist, it will be automatically created.
     */
    public void addSubscribers(String listId, java.util.List<PutSubscriptionsRecipient> request) {
        addSubscribers(listId, request, null);
    }

    /**
     * Subscribes additional users to the list, without modifying existing subscriptions. If the list does not exist, it will be automatically created.
     */
    public void addSubscribers(
            String listId, java.util.List<PutSubscriptionsRecipient> request, IdempotentRequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lists")
                .addPathSegment(listId)
                .addPathSegments("subscriptions")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Subscribe a user to an existing list (note: if the List does not exist, it will be automatically created).
     */
    public void subscribe(String listId, String userId) {
        subscribe(listId, userId, SubscribeUserToListRequest.builder().build());
    }

    /**
     * Subscribe a user to an existing list (note: if the List does not exist, it will be automatically created).
     */
    public void subscribe(String listId, String userId, SubscribeUserToListRequest request) {
        subscribe(listId, userId, request, null);
    }

    /**
     * Subscribe a user to an existing list (note: if the List does not exist, it will be automatically created).
     */
    public void subscribe(
            String listId, String userId, SubscribeUserToListRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lists")
                .addPathSegment(listId)
                .addPathSegments("subscriptions")
                .addPathSegment(userId)
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("PUT", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Delete a subscription to a list by list ID and user ID.
     */
    public void unsubscribe(String listId, String userId) {
        unsubscribe(listId, userId, null);
    }

    /**
     * Delete a subscription to a list by list ID and user ID.
     */
    public void unsubscribe(String listId, String userId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lists")
                .addPathSegment(listId)
                .addPathSegments("subscriptions")
                .addPathSegment(userId)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
