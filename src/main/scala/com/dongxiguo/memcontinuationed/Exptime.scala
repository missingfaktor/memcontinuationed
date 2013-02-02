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

import java.util.Date

final class Exptime(val value: Long) extends AnyVal

object Exptime {

  final val NeverExpires: Exptime = new Exptime(0L)

  final def unixTime(date: Date): Exptime = {
    val result = (date.getTime / 1000).toInt
    if (result >= 0 && result <= 60 * 60 * 24 * 30 || result > 0xFFFFFFFFL) {
      throw new IllegalArgumentException
    }
    new Exptime(result)
  }

  final def fromNowOn(seconds: Int): Exptime = {
    if (seconds >= 0 && seconds <= 60 * 60 * 24 * 30) {
      new Exptime(seconds)
    } else {
      throw new IllegalArgumentException
    }
  }

}