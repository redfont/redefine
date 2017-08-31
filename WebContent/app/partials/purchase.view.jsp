<div>
Prospect View: <br>
	<div style="display: table">
		<div style="display: table-row;" ng-show="vm.isProspect">
			<div style="display: table-cell;text-align: right;">
				<md-button class="md-button md-raised md-primary button-override" ng-click="vm.showDialog($event, 0)">add new</md-button>
			</div>			
		</div>
		<div style="display: table-row;">
			<div style="display: table-cell">
				<table>
					<tr>		
						<td>Purchase Date</td>				
						<td>PO #</td>
						<td>Supplier</td>
						<td>Amount</td>
						<td>Date Created</td>
						<td>Created By</td>
						<td>Date Updated</td>
						<td>Updated By</td>
					</tr>
					<tr ng-repeat="p in vm.purchases" ng-dblclick="vm.showDialog($event,p.id)" title="Click row to update">
						<td>{{p.poDate | date: 'yyyy-MM-dd'}}</td>
						<td>{{p.poid}} </td>
						<td>{{p.supplier}}</td>
						<td>{{p.amnt}}</td>
						<td>{{p.dateCreated | date: 'yyyy-MM-dd HH:mm:ss'}}</td>
						<td>{{p.createdBy}}</td>
						<td>{{p.dateUpdated | date: 'yyyy-MM-dd HH:mm:ss'}}</td>
						<td>{{p.updatedBy}}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>