package com.sx.icecap.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sx.icecap.model.DataType;


public class GroupIdComparator extends OrderByComparator<DataType> {
	public static final String ORDER_BY_ASC =
			"DataType.groupId ASC";

		public static final String[] ORDER_BY_CONDITION_FIELDS = {"groupId"};

		public static final String ORDER_BY_DESC =
			"DataType.groupId DESC";

		public static final String[] ORDER_BY_FIELDS = {"groupId"};
		
		public GroupIdComparator( boolean sortOrder) {
			this._ascending = sortOrder;
		}

		@Override
		public int compare(DataType entry1, DataType entry2) {
			int value = (int)(entry1.getGroupId() - entry2.getGroupId());

			if (value == 0) {
				if (entry1.getPrimaryKey() < entry2.getPrimaryKey()) {
					value = -1;
				}
				else if (entry1.getPrimaryKey() >= entry2.getPrimaryKey()) {
					value = 1;
				}
			}

			if (_ascending) {
				return value;
			}

			return -value;
		}

		@Override
		public String getOrderBy() {
			if (_ascending) {
				return ORDER_BY_ASC;
			}

			return ORDER_BY_DESC;
		}

		@Override
		public String[] getOrderByConditionFields() {
			return ORDER_BY_CONDITION_FIELDS;
		}

		@Override
		public String[] getOrderByFields() {
			return ORDER_BY_FIELDS;
		}

		@Override
		public boolean isAscending() {
			return _ascending;
		}

		private final boolean _ascending;
}
