/*
 * Copyright 2013 深圳市葡萄藤网络科技有限公司 (Shenzhen Putaoteng Network Technology Co., Ltd.)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dongxiguo.memcontinuationed

import java.io._

final class UTF8Accessor(override val key: String) 
  extends StorageAccessor[String] {
  override final def encode(output: OutputStream, data: String, flags: Int) {
    output.write(data.getBytes("UTF-8"))
  }

  override final def decode(input: InputStream, flags: Int): String = {
    val result = new Array[Byte](input.available)
    input.read(result)
    new String(result, "UTF-8")
  }
}


// vim: set ts=2 sw=2 et:
