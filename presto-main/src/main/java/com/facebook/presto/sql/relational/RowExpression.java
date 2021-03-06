/*
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
package com.facebook.presto.sql.relational;

import com.facebook.presto.spi.type.Type;
import com.google.common.base.Function;

public abstract class RowExpression
{
    public abstract Type getType();

    public abstract boolean equals(Object other);
    public abstract int hashCode();

    public abstract String toString();

    public static Function<RowExpression, Type> typeGetter()
    {
        return new Function<RowExpression, Type>()
        {
            @Override
            public Type apply(RowExpression input)
            {
                return input.getType();
            }
        };
    }

    public abstract <C, R> R accept(RowExpressionVisitor<C, R> visitor, C context);
}
