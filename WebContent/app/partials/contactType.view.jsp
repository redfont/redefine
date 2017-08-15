<div>
ContactType View: <br>
	<div style="display: table">
		<div style="display: table-row;">
			<div style="display: table-cell;text-align: right;">
				<md-button class="md-button md-raised md-primary button-override" ng-click="vm.showDialog($event, 0)">add new</md-button>
			</div>			
		</div>
		<div style="display: table-row;">
			<div style="display: table-cell">
				<table>
					<tr>
						<td>Code</td>
						<td>Description</td>
						<td>Created By</td>
						<td>Date Created</td>
						<td>Updated By</td>
						<td>Date Updated</td>
					</tr>
					<tr ng-repeat="c in vm.contactTypes" ng-dblclick="vm.showDialog($event, c.code)" title="Double click to see details...">
						<td>{{c.code}}</td>
						<td>{{c.description}}</td>
						<td>{{c.createdBy}}</td>
						<td>{{c.dateCreated | date: 'yyyy-MM-dd HH:mm:ss'}}</td>
						<td>{{c.updatedBy}}</td>
						<td>{{c.dateUpdated | date: 'yyyy-MM-dd HH:mm:ss'}}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>