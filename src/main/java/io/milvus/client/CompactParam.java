/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.milvus.client;

/** Contains parameters for <code>compact</code> */
public class CompactParam {
  private io.milvus.grpc.CompactParam.Builder builder;

  /** @param collectionName collection to compact */
  public static CompactParam create(String collectionName) {
    return new CompactParam(collectionName);
  }

  private CompactParam(String collectionName) {
    builder = io.milvus.grpc.CompactParam.newBuilder();
    builder.setCollectionName(collectionName).setThreshold(0.2);
  }

  /**
   * Optional. Default to 0.2. Segment will compact if and only if the percentage of entities
   * deleted exceeds the threshold.
   *
   * @param threshold The threshold
   */
  public CompactParam setThreshold(double threshold) {
    builder.setThreshold(threshold);
    return this;
  }

  io.milvus.grpc.CompactParam grpc() {
    return builder.build();
  }
}
